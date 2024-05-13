package starter.stepdefinitions.Orders_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Orders.GetAllOrders;

public class GetAllOrders_Steps {
    @Steps
    GetAllOrders getAllOrders;

    @Given("I set the API endpoint to get all data orders")
    public void setAPIEndpointGetAllDataOrders(){
        getAllOrders.setAPIEndpointGetAllDataOrders();
    }

    @When("I send a request to retrieve all data orders")
    public void sendRequestRetrieveAllDataOrders(){
        getAllOrders.sendRequestRetrieveAllDataOrders();
    }

    @Then("I receive all valid orders data from Alta Shop")
    public void receiveOrdersData(){
        getAllOrders.receiveOrdersData();
    }
}
