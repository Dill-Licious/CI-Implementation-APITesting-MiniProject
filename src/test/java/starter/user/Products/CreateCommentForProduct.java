package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateCommentForProduct {
    public static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set API endpoint to create a comment for a product")
    public String setAPIEndpointCreateComment(){
        return url + "88701/comments"; //ID = 88701
    }

    @Step("I send a request to create a comment for a product")
    public void sendRequestCreateComment(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .body(requestBody.toString())
                .post(setAPIEndpointCreateComment());
    }

    @Step("Then I receive a comment that I have made")
    public void receiveCommentThatIMade(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_COMMENT_FOR_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Content", Matchers.equalTo("the games are great including Gran Turismo 7 but sadly GT4 is much better")));
        restAssuredThat(response -> response.body("data.User", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data.Product", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data.Comment", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
