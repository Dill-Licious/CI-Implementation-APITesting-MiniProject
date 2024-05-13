package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.GetProductByID;

public class GetProductByID_Steps {
    @Steps
    GetProductByID getProductByID;

    @Given("I set API endpoint to get specific product info by ID")
    public void setAPIEndpointGetProductByID(){
        getProductByID.setAPIEndpointGetProductByID();
    }

    @When("I send a request to get specific product info by valid ID")
    public void sendRequestGetProductByID(){
        getProductByID.sendRequestGetProductByID();
    }

    @Then("I should receive the product data by its ID")
    public void receiveProductDataByID(){
        getProductByID.receiveProductDataByID();
    }
}
