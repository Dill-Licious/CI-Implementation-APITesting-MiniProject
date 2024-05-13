package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Login;

public class Login_Steps {
    @Steps
    Login login;

    @Given("I set the API endpoint to login into Alta Shop")
    public void setAPIEndpointLogin(){
        login.setAPIEndpointLogin();
    }

    @When("I send a request to login into Alta Shop with valid credentials")
    public void sendRequestLoginValidData(){
        login.sendRequestLoginValidData();
    }

    @Then("I should receive a data confirmation that indicating success login")
    public void validateSuccessLogin(){
        login.validateSuccessLogin();
    }

    @When("I send a request to login into Alta Shop with invalid email")
    public void sendRequestLoginInvalidEmail(){
        login.sendRequestLoginInvalidEmail();
    }

    @And("I should receive a status code of 400 Bad Request")
    public void getStatusCode400(){
        login.getStatusCode400();
    }

    @Then("I receive an error message indicate record not found")
    public void receiveErrorMessageRecordNotFound(){
        login.receiveErrorMessageRecordNotFound();
    }

    @When("I send a request to login into Alta Shop with invalid password")
    public void sendRequestLoginInvalidPassword(){
        login.sendRequestLoginInvalidPassword();
    }

    @Then("I receive an error message indicate invalid password")
    public void receiveErrorMessageInvalidPassword(){
        login.receiveErrorMessageInvalidPassword();
    }

    @When("I send a request to login into Alta Shop with empty data email and password")
    public void sendRequestLoginEmptyData(){
        login.sendRequestLoginEmptyData();
    }

    @Then("I receive an error message indicate must filled required field")
    public void receiveErrorMessageMustFilledRequiredField(){
        login.receiveErrorMessageMustFilledRequiredField();
    }
}