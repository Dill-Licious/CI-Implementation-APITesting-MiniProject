package starter.stepdefinitions.ProductsCategories_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductsCategories.GetCategoryByID;

public class GetCategoryByID_steps {
    @Steps
    GetCategoryByID getCategoryByID;

    @Given("I set the API endpoint to get a category by ID")
    public void setAPIEndpointGetCategoryByID(){
        getCategoryByID.setAPIEndpointGetCategoryByID();
    }

    @When("I send a request to get the category by ID")
    public void sendRequestGetCategoryByID(){
        getCategoryByID.sendRequestGetCategoryByID();
    }

    @Then("I should receive the category details including ID, Name, and Description")
    public void receiveDetailCategoryByID(){
        getCategoryByID.receiveDetailCategoryByID();
    }


    //Negatif Scenario
    @Given("I set the API endpoint to get a category by invalid ID")
    public void setAPIEndpointGetCategoryByInvalidID(){
        getCategoryByID.setAPIEndpointGetCategoryByInvalidID();
    }

    @When("I send a request to get the category by invalid ID")
    public void sendRequestGetCategoryInvalidID(){
        getCategoryByID.sendRequestGetCategoryInvalidID();
    }

    @And("I should receive a status code of 404 Not Found")
    public void statusCode404(){
        getCategoryByID.statusCode404();
    }

    @Then("I should receive an error message indicate record not found")
    public void receiveErrorMessageRecordNotFound(){
        getCategoryByID.receiveErrorMessageRecordNotFound();
    }

}
