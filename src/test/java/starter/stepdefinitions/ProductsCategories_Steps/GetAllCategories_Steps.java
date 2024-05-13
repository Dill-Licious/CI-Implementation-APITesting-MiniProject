package starter.stepdefinitions.ProductsCategories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductsCategories.GetAllCategories;

public class GetAllCategories_Steps {
    @Steps
    GetAllCategories getAllCategories;

    @Given("I set the API endpoint to get all product categories")
    public void setAPIEndpointGetAllProductCategories(){
        getAllCategories.setAPIEndpointGetAllProductCategories();
    }

    @When("I send a request to get all product categories")
    public void sendRequestGetAllProductCategories(){
        getAllCategories.sendRequestGetAllProductCategories();
    }

    @Then("I receive all data product categories")
    public void receiveAllDataProductCategories(){
        getAllCategories.receiveAllDataProductCategories();
    }
}
