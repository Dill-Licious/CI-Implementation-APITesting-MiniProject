package starter.stepdefinitions.Authentication_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Authentication.Register;

public class Register_Steps {
    @Steps
    Register register;

    @Given("I set the API endpoint to register into Alta Shop")
    public void setAPIEndpointRegister(){
        register.setAPIEndpointRegister();
    }

    @When("I send a request to register into Alta Shop with valid credentials")
    public void sendRequestRegisterValidData(){
        register.sendRequestRegisterValidData();
    }

    @Then("I should receive a data confirmation that indicating register success")
    public void validateSuccessRegister(){
        register.validateSuccessRegister();
    }
}
