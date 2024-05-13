package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.GetUserInformation;

public class GetUserInformation_Steps {
    @Steps
    GetUserInformation getUserInformation;

    @Given("I set API endpoint to get user information")
    public void setAPIEndpointGetUserInfo(){
        getUserInformation.setAPIEndpointGetUserInfo();
    }

    @When("I send a request to get user information")
    public void sendRequestGetUserInfo(){
        getUserInformation.sendRequestGetUserInfo();
    }

    @Then("I receive user information who has successfully logged in")
    public void receiveUserInfo(){
        getUserInformation.receiveUserInfo();
    }
}
