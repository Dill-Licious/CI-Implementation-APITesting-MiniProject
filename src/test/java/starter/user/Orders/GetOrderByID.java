package starter.user.Orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetOrderByID {
    public static String url = "https://altashop-api.fly.dev/api/orders/";

    @Step("I set the API endpoint to get specific order by ID")
    public String setAPIEndpointGetOrderByValidID(){
        return url + "13793"; //ID = 13793
    }

    @Step("I send a request to get specific order by ID")
    public void sendRequestGetOrderByValidID(){
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

        SerenityRest.given()
                .header("Authorization", "Bearer " + token) // Menambahkan token ke header
                .get(setAPIEndpointGetOrderByValidID());
    }

    @Step("I should receive a data response containing the details of the order")
    public void receiveDataOrderByValidID(){
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDER_BY_ID_SCHEMA);

        restAssuredThat(response -> response.body("data.ID", Matchers.equalTo(13793)));
        restAssuredThat(response -> response.body("data.User.ID", Matchers.equalTo(31506)));
        restAssuredThat(response -> response.body("data.User.Fullname", Matchers.equalTo("Firstname Lastname")));
        restAssuredThat(response -> response.body("data.User.Email", Matchers.equalTo("someone@mail.com")));
        restAssuredThat(response -> response.body("data.User.Password", Matchers.equalTo("123123")));
        restAssuredThat(response -> response.body("data.Product", Matchers.nullValue()));
        restAssuredThat(response -> response.body("data.Quantity", Matchers.equalTo(1)));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
