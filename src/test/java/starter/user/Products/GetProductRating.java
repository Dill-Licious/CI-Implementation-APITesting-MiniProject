package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetProductRating {
    public static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set API endpoint to get product rating with specific ID")
    public String setAPIEndpointGetProductRating(){
        return url + "88701/ratings";
    }

    @Step("I send a request to get product rating with specific ID")
    public void sendRequestGetProductRating(){
        SerenityRest.given()
                .get(setAPIEndpointGetProductRating());
    }

    @Step("I receive an product rating data from specific ID")
    public void receiveProductRatingData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATING_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.notNullValue())); //Sering berubah.pakai notnullvalue untuk menghindari error

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Negatif Scenario
    @Step("I set API endpoint to get product rating with invalid ID")
    public String setAPIEndpointGetProductRatingInvalidID(){
        return url + "900000/ratings";
    }

    @Step("I send a request to get product rating with invalid ID")
    public void sendRequestGetProductRatingInvalidID(){
        SerenityRest.given()
                .get(setAPIEndpointGetProductRatingInvalidID());
    }

    @Step("I receive a rating data of 0")
    public void receiveRatingDataNol(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATING_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.equalTo(0)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
