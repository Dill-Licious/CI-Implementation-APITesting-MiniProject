package starter.stepdefinitions.Orders_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Orders.GetOrderByID;

public class GetOrderByID_Steps {
    @Steps
    GetOrderByID getOrderByID;

    @Given("I set the API endpoint to get specific order by ID")
    public void setAPIEndpointGetOrderByValidID(){
        getOrderByID.setAPIEndpointGetOrderByValidID();
    }

    @When("I send a request to get specific order by ID")
    public void sendRequestGetOrderByValidID(){
        getOrderByID.sendRequestGetOrderByValidID();
    }

    @Then("I should receive a data response containing the details of the order")
    public void receiveDataOrderByValidID(){
        getOrderByID.receiveDataOrderByValidID();
    }
}
