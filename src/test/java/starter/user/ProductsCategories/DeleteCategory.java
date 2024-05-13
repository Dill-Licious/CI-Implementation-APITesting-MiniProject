package starter.user.ProductsCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteCategory {
    public static String url = "https://altashop-api.fly.dev/api/categories/";

    @Step("I set the API endpoint to delete a category by ID")
    public String setAPIEndpointDeleteCategoryByID(){
        return url + "31969"; //ID = 31969
    }

    @Step("I send a request to delete the category by ID")
    public void sendRequestDeleteCategory(){
        SerenityRest.given()
                .delete(setAPIEndpointDeleteCategoryByID());
    }

    @Step("I receive a null data that indicate category has been deleted")
    public void receiveNullDataDeletedCategory(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_CATEGORY_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
