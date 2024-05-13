package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.CreateCommentForProduct;

public class CreateCommentForProduct_Steps {
    @Steps
    CreateCommentForProduct createCommentForProduct;

    @Given("I set API endpoint to create a comment for a product")
    public void setAPIEndpointCreateComment(){
        createCommentForProduct.setAPIEndpointCreateComment();
    }

    @When("I send a request to create a comment for a product")
    public void sendRequestCreateComment(){
        createCommentForProduct.sendRequestCreateComment();
    }

    @Then("Then I receive a comment that I have made")
    public void receiveCommentThatIMade(){
        createCommentForProduct.receiveCommentThatIMade();
    }
}
