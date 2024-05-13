package starter.stepdefinitions.Orders_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.Orders.CreateNewOrder;

public class CreateNewOrder_Steps {
    @Steps
    CreateNewOrder createNewOrder;

    @Given("I set the API endpoint to create a new order")
    public void setAPIEndpointCreateNewOrder(){
        createNewOrder.setAPIEndpointCreateNewOrder();
    }

    @When("I send a request to create a new order with valid credentials")
    public void sendRequestCreateNewValidOrder(){
        createNewOrder.sendRequestCreateNewValidOrder();
    }

    @Then("I should receive confirmation data about the product that I bought")
    public void receiveConfirmationValidDataProduct(){
        createNewOrder.receiveConfirmationValidDataProduct();
    }
}
