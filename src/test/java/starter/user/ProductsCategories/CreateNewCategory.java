package starter.user.ProductsCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewCategory {
    public static String url = "https://altashop-api.fly.dev/api/categories";

    @Step("I set the API endpoint to create a new category")
    public String setAPIEndpointCreateNewCategory(){
        return url;
    }

    @Step("I send a request to create a new category")
    public void sendRequestCreateNewCategory(){
        JSONObject categoryObject = new JSONObject();
        categoryObject.put("name", "gaming");
        categoryObject.put("description", "for gaming purposes");

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(categoryObject.toString())
                .post(setAPIEndpointCreateNewCategory());
    }

    @Step("I receive new category data")
    public void receiveNewCategoryData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_CATEGORY_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("gaming")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("for gaming purposes")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
