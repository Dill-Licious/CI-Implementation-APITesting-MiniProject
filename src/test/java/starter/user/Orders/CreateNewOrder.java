package starter.user.Orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class CreateNewOrder {
    public static String url = "https://altashop-api.fly.dev/api/orders";

    @Step("I set the API endpoint to create a new order")
    public String setAPIEndpointCreateNewOrder(){
        return url;
    }

    @Step("I send a request to create a new order with valid credentials")
    public void sendRequestCreateNewValidOrder(){
        JSONArray productsArray = new JSONArray();
        JSONObject product = new JSONObject();
        product.put("product_id", 2);
        product.put("quantity", 1);
        productsArray.put(product);

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(productsArray.toString())
                .post(setAPIEndpointCreateNewOrder());

    }

    @Step("I should receive confirmation data about the product that I bought")
    public void receiveConfirmationValidDataProduct(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ORDER_SCHEMA);

        restAssuredThat(response -> response.body("data[0].ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data[0].User.ID", Matchers.equalTo(31506)));
        restAssuredThat(response -> response.body("data[0].User.Fullname", Matchers.equalTo("Firstname Lastname")));
        restAssuredThat(response -> response.body("data[0].User.Email", Matchers.equalTo("someone@mail.com")));
        restAssuredThat(response -> response.body("data[0].User.Password", Matchers.equalTo("123123")));
        restAssuredThat(response -> response.body("data[0].Product", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data[0].Quantity", Matchers.equalTo(1)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
