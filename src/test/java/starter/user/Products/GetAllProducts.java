package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProducts {
    private static String url = "https://altashop-api.fly.dev/api/products";

    @Step("I set the API endpoint to retrieve all data products from Alta Shop API")
    public String setAPIEndpointAllDataProducts(){
        return url;
    }

    @Step("I send a request to retrieve all data products")
    public void sendRequestAllDataProducts(){
        SerenityRest.given()
                .get(setAPIEndpointAllDataProducts());
    }

    @Step("I should receive a status code of 200")
    public void statusCode200(){
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I should receive valid data for all products")
    public void receiveAllDataProducts(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Categories", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
