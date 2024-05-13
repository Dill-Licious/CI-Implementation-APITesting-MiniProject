package starter.user.Hello;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetIndexHello {
    public static String url = "https://altashop-api.fly.dev/api/hello";

    @Step("I set the API endpoint to retrieve the index page that returns a greeting message")
    public String setAPIEndpointIndexPage(){
        return url;
    }

    @Step("I send a request to receive greeting message")
    public void sendRequestIndexPage(){
        SerenityRest.given()
                .get(setAPIEndpointIndexPage());
    }

    @Step("I receive a hello message")
    public void receiveHelloMessage(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_INDEX_HELLO_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.equalTo("hello")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
