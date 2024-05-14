package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetUserInformation {
    public static String url = "https://altashop-api.fly.dev/api/auth/info";

    @Step("I set API endpoint to get user information")
    public String setAPIEndpointGetUserInfo(){
        return url;
    }

    @Step("I send a request to get user information")
    public void sendRequestGetUserInfo(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .get(setAPIEndpointGetUserInfo());
    }

    @Step("I receive user information who has successfully logged in")
    public void receiveUserInfo(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_INFORMATION_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(31506)));
        restAssuredThat(response -> response.body("data.Fullname", Matchers.equalTo("Firstname Lastname")));
        restAssuredThat(response -> response.body("data.Email", Matchers.equalTo("someone@mail.com")));
        restAssuredThat(response -> response.body("data.Password", Matchers.equalTo("123123")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    //Negatif Scenario
    @Step("I send a request to get user information without token")
    public void sendRequestUserInfoWithoutToken(){
        SerenityRest.given()
                .get(setAPIEndpointGetUserInfo());
    }

    @Step("I should receive a status code of 401 Unauthorized")
    public void statusCode401(){
        restAssuredThat(response -> response.statusCode(401));
    }

    @Step("I should receive an error message indicate unauthorized")
    public void receiveErrorMessageUnauthorized(){
        restAssuredThat(response -> response.body("error", Matchers.equalTo("unauthorized")));
    }
}
