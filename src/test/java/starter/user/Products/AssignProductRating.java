package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class AssignProductRating {
    public static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set API endpoint to assign a rating to specific product")
    public String setAPIEndpointAssignRating(){
        return url + "88714/ratings"; //ID = 88704
    }

    @Step("I send a request to assign a rating to specific product")
    public void sendRequestAssignRating(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("count", "4");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .body(requestBody.toString())
                .post(setAPIEndpointAssignRating());
    }

    @Step("I receive an update data rating from the product")
    public void receiveUpdateRating(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ASSIGN_PRODUCT_RATING_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(88714)));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("Sony PS5")));
        restAssuredThat(response -> response.body("data.Description", equalTo("play has no limits")));
        restAssuredThat(response -> response.body("data.Price", Matchers.equalTo(299)));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.notNullValue())); //rating sering berganti2
        restAssuredThat(response -> response.body("data.Categories", Matchers.empty()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
