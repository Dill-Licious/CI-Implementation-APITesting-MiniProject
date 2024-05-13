package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {
    public static String url = "https://altashop-api.fly.dev/api/auth/login";

    @Step("I set the API endpoint to login into Alta Shop")
    public String setAPIEndpointLogin(){
        return url;
    }

    @Step("I send a request to login into Alta Shop with valid credentials")
    public void sendRequestLoginValidData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I should receive a data confirmation that indicating success login")
    public void validateSuccessLogin(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a request to login into Alta Shop with invalid email")
    public void sendRequestLoginInvalidEmail(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone12@mail.com");
        requestBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I should receive a status code of 400 Bad Request")
    public void getStatusCode400(){
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive an error message indicate record not found")
    public void receiveErrorMessageRecordNotFound(){
        restAssuredThat(response -> response.body("error", Matchers.equalTo("record not found")));
    }

    @Step("I send a request to login into Alta Shop with invalid password")
    public void sendRequestLoginInvalidPassword(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "someone@mail.com");
        requestBody.put("password", "123123444"); //valid password: 123123

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I receive an error message indicate invalid password")
    public void receiveErrorMessageInvalidPassword(){
        restAssuredThat(response -> response.body("error", Matchers.equalTo("email or password is invalid")));
    }

    @Step("I send a request to login into Alta Shop with empty data email and password")
    public void sendRequestLoginEmptyData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", ""); //valid email: someone@mail.com
        requestBody.put("password", ""); //valid password: 123123

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I receive an error message indicate must filled required field")
    public void receiveErrorMessageMustFilledRequiredField(){
        restAssuredThat(response -> response.body("error", Matchers.equalTo("email is required")));
    }

}
