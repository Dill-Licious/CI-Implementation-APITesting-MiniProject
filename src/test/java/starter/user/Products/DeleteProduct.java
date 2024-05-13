package starter.user.Products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class DeleteProduct {
    public static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set the API endpoint to delete a specific product by ID")
    public String setAPIEndpointDeleteProductByID(){
        return url + "2";
    }

    @Step("I send a request to delete a specific product by ID")
    public void sendRequestDeleteProductByID(){
        SerenityRest.given()
                .delete(setAPIEndpointDeleteProductByID());
    }

    @Step("I receive a null data that indicate product has been deleted")
    public void receiveNullDataProductDeleted(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.DELETE_PRODUCT_SCHEMA);

        restAssuredThat(response -> response.body("data", Matchers.nullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
