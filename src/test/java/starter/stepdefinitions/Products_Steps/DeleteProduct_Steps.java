package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.DeleteProduct;

public class DeleteProduct_Steps {
    @Steps
    DeleteProduct deleteProduct;

    @Given("I set the API endpoint to delete a specific product by ID")
    public void setAPIEndpointDeleteProductByID(){
        deleteProduct.setAPIEndpointDeleteProductByID();
    }

    @When("I send a request to delete a specific product by ID")
    public void sendRequestDeleteProductByID(){
        deleteProduct.sendRequestDeleteProductByID();
    }

    @Then("I receive a null data that indicate product has been deleted")
    public void receiveNullDataProductDeleted(){
        deleteProduct.receiveNullDataProductDeleted();
    }
}
