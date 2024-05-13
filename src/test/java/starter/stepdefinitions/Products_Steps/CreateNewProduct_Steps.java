package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.CreateNewProduct;

public class CreateNewProduct_Steps {
    @Steps
    CreateNewProduct createNewProduct;

    @Given("I set the API endpoint to add a new product to Alta Shop API")
    public void setAPIEndpointAddNewProduct(){
        createNewProduct.setAPIEndpointAddNewProduct();
    }

    @When("I send a request to add a new product")
    public void sendRequestAddNewProduct(){
        createNewProduct.sendRequestAddNewProduct();
    }

    @Then("I should see my product successfully added")
    public void validateProductSuccessAdded(){
        createNewProduct.validateProductSuccessAdded();
    }
}
