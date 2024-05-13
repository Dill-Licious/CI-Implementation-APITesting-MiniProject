package starter.user.ProductsCategories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllCategories {
    public static String url = "https://altashop-api.fly.dev/api/categories";

    @Step("I set the API endpoint to get all product categories")
    public String setAPIEndpointGetAllProductCategories(){
        return url;
    }

    @Step("I send a request to get all product categories")
    public void sendRequestGetAllProductCategories(){
        SerenityRest.given()
                .get(setAPIEndpointGetAllProductCategories());
    }

    @Step("I receive all data product categories")
    public void receiveAllDataProductCategories(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Name", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Description", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
