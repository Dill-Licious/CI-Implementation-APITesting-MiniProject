package starter.stepdefinitions.Products_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Products.GetProductRating;

public class GetProductRating_Steps {
    @Steps
    GetProductRating getProductRating;

    @Given("I set API endpoint to get product rating with specific ID")
    public void setAPIEndpointGetProductRating(){
        getProductRating.setAPIEndpointGetProductRating();
    }

    @When("I send a request to get product rating with specific ID")
    public void sendRequestGetProductRating(){
        getProductRating.sendRequestGetProductRating();
    }

    @Then("I receive an product rating data from specific ID")
    public void receiveProductRatingData(){
        getProductRating.receiveProductRatingData();
    }
}
