package starter.stepdefinitions.ProductsCategories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductsCategories.CreateNewCategory;

public class CreateNewCategory_Steps {
    @Steps
    CreateNewCategory createNewCategory;

    @Given("I set the API endpoint to create a new category")
    public void setAPIEndpointCreateNewCategory(){
        createNewCategory.setAPIEndpointCreateNewCategory();
    }

    @When("I send a request to create a new category")
    public void sendRequestCreateNewCategory(){
        createNewCategory.sendRequestCreateNewCategory();
    }

    @Then("I receive new category data")
    public void receiveNewCategoryData(){
        createNewCategory.receiveNewCategoryData();
    }
}
