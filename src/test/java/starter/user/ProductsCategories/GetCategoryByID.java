package starter.user.ProductsCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetCategoryByID {
    public static String url = "https://altashop-api.fly.dev/api/categories/";

    @Step("I set the API endpoint to get a category by ID")
    public String setAPIEndpointGetCategoryByID(){
        return url + "32080"; //ID = 32080
    }

    @Step("I send a request to get the category by ID")
    public void sendRequestGetCategoryByID(){
        SerenityRest.given()
                .get(setAPIEndpointGetCategoryByID());
    }

    @Step("I should receive the category details including ID, Name, and Description")
    public void receiveDetailCategoryByID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(32080)));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("gaming")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("for gaming purposes")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
