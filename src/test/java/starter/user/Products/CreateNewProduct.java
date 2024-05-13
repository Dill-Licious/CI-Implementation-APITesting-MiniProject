package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewProduct {
    private static String url = "https://altashop-api.fly.dev/api/products";

    @Step("I set the API endpoint to add a new product toS Alta Shop API")
    public String setAPIEndpointAddNewProduct(){
        return url;
    }

    @Step("I send a request to add a new product")
    public void sendRequestAddNewProduct(){
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Sony PS5");
        requestBody.put("description", "play has no limits");
        requestBody.put("price", 299);

        JSONArray categoriesArray = new JSONArray();
        categoriesArray.put(1);
        requestBody.put("categories", categoriesArray);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointAddNewProduct());
    }

    @Step("I should see my product successfully added")
    public void validateProductSuccessAdded(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.equalTo("Sony PS5")));
        restAssuredThat(response -> response.body("data.Description", Matchers.equalTo("play has no limits")));
        restAssuredThat(response -> response.body("data.Price", Matchers.equalTo(299)));
        restAssuredThat(response -> response.body("data.Ratings", Matchers.equalTo(0)));
        restAssuredThat(response -> response.body("data.Categories", Matchers.empty()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }




}
