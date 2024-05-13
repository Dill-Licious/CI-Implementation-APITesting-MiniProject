package starter.stepdefinitions.ProductsCategories_Steps;

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


}
