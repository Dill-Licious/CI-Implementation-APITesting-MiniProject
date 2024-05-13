package starter.user.Authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Register {
    public static String url = "https://altashop-api.fly.dev/api/auth/register";

    @Step("I set the API endpoint to register into Alta Shop")
    public String setAPIEndpointRegister(){
        return url;
    }

    //Reminder untuk ganti setiap test
    @Step("I send a request to register into Alta Shop with valid credentials")
    public void sendRequestRegisterValidData(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Irfan009200@mail.com");
        requestBody.put("password", "123123");
        requestBody.put("fullname", "Irfan Semester Enam");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointRegister());
    }

    @Step("I should receive a data confirmation that indicating register success")
    public void validateSuccessRegister(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Fullname", Matchers.equalTo("Irfan Semester Enam")));
        restAssuredThat(response -> response.body("data.Email", Matchers.equalTo("Irfan009200@mail.com")));
        restAssuredThat(response -> response.body("data.Password", Matchers.equalTo("123123")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
