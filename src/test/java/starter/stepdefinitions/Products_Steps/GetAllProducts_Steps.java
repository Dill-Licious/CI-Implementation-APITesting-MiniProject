package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.GetAllProducts;

public class GetAllProducts_Steps {
    @Steps
    GetAllProducts getAllProducts;

    @Given("I set the API endpoint to retrieve all data products from Alta Shop API")
    public void setAPIEndpointAllDataProducts(){
        getAllProducts.setAPIEndpointAllDataProducts();
    }

    @When("I send a request to retrieve all data products")
    public void sendRequestAllDataProducts(){
        getAllProducts.sendRequestAllDataProducts();
    }

    @And("I should receive a status code of 200")
    public void statusCode200(){
        getAllProducts.statusCode200();
    }

    @Then("I should receive valid data for all products")
    public void receiveAllDataProducts(){
        getAllProducts.receiveAllDataProducts();
    }
}
