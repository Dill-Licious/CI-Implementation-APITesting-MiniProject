package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetProductByID {
    private static String url = "https://altashop-api.fly.dev/api/products/";

    //ID = 2
    @Step("I set API endpoint to get specific product info by ID")
    public String setAPIEndpointGetProductByID(){
        return url + "?ID=2";
    }

    @Step("I send a request to get specific product info by valid ID")
    public void sendRequestGetProductByID(){
        SerenityRest.given()
                .get(setAPIEndpointGetProductByID());
    }

    @Step("I should receive the product data by its ID")
    public void receiveProductDataByID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Categories", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
