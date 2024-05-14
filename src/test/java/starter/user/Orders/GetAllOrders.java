package starter.user.Orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllOrders {
    public static String url = "https://altashop-api.fly.dev/api/orders";

    @Step("I set the API endpoint to get all data orders")
    public String setAPIEndpointGetAllDataOrders(){
        return url;
    }

    @Step("I send a request to retrieve all data orders")
    public void sendRequestRetrieveAllDataOrders(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .get(setAPIEndpointGetAllDataOrders());
    }

    @Step("I receive all valid orders data from Alta Shop")
    public void receiveOrdersData(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDERS_SCHEMA);

        restAssuredThat(response -> response.body("data.Product", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Price", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Quantity", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Subtotal", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send a request with invalid method to retrieve all data orders")
    public void sendRequestRetrieveAllDataOrdersInvalidMethod(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .post(setAPIEndpointGetAllDataOrders()); //harusnya: get
    }

    @Step("I receive an error message indicate end of file")
    public void receiveErrorMessageEOF(){
        restAssuredThat(response -> response.body("error", Matchers.equalTo("EOF")));
    }
}
