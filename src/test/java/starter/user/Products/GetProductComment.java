package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetProductComment {
    public static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set API endpoint to get a product comment with specific ID")
    public String setAPIEndpointGetProductComment(){
        return url + "88712/comments";
    }

    @Step("I send a request to get product comment with specific ID")
    public void sendRequestGetProductComment(){
        SerenityRest.given()
                .get(setAPIEndpointGetProductComment());
    }

    @Step("I receive the comment data form ID that I am looking for")
    public void receiveCommentFromID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_COMMENT_SCHEMA);

        restAssuredThat(response -> response.body("data[0].ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data[0].Content", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data[0].User", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data[0].Product", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data[0].Comment", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
