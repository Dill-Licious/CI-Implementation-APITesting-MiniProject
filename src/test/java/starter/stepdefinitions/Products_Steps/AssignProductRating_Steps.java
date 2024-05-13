package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.AssignProductRating;

public class AssignProductRating_Steps {
    @Steps
    AssignProductRating assignProductRating;

    @Given("I set API endpoint to assign a rating to specific product")
    public void setAPIEndpointAssignRating(){
        assignProductRating.setAPIEndpointAssignRating();
    }

    @When("I send a request to assign a rating to specific product")
    public void sendRequestAssignRating(){
        assignProductRating.sendRequestAssignRating();
    }

    @Then("I receive an update data rating from the product")
    public void receiveUpdateRating(){
        assignProductRating.receiveUpdateRating();
    }
}
