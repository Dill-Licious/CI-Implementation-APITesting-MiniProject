package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.GetProductComment;

public class GetProductComment_Steps {
    @Steps
    GetProductComment getProductComment;

    @Given("I set API endpoint to get a product comment with specific ID")
    public void setAPIEndpointGetProductComment(){
        getProductComment.setAPIEndpointGetProductComment();
    }

    @When("I send a request to get product comment with specific ID")
    public void sendRequestGetProductComment(){
        getProductComment.sendRequestGetProductComment();
    }

    @Then("I receive the comment data form ID that I am looking for")
    public void receiveCommentFromID(){
        getProductComment.receiveCommentFromID();
    }
}
