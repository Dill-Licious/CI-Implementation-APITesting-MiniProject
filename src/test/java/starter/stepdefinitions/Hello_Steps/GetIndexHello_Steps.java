package starter.stepdefinitions.Hello_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Hello.GetIndexHello;

public class GetIndexHello_Steps {
    @Steps
    GetIndexHello getIndexHello;

    @Given("I set the API endpoint to retrieve the index page that returns a greeting message")
    public void setAPIEndpointIndexPage(){
        getIndexHello.setAPIEndpointIndexPage();
    }

    @When("I send a request to receive greeting message")
    public void sendRequestIndexPage(){
        getIndexHello.sendRequestIndexPage();
    }

    @Then("I receive a hello message")
    public void receiveHelloMessage(){
        getIndexHello.receiveHelloMessage();
    }
}
