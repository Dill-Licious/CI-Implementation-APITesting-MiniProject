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

    //Negatif Scenario
    @Given("I set API endpoint to get product rating with invalid ID")
    public void setAPIEndpointGetProductRatingInvalidID(){
        getProductRating.setAPIEndpointGetProductRatingInvalidID();
    }

    @When("I send a request to get product rating with invalid ID")
    public void sendRequestGetProductRatingInvalidID(){
        getProductRating.sendRequestGetProductRatingInvalidID();
    }

    @Then("I receive a rating data of 0")
    public void receiveRatingDataNol(){
        getProductRating.receiveRatingDataNol();
    }
}
