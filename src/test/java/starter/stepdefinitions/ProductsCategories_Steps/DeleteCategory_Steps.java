package starter.stepdefinitions.ProductsCategories_Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.ProductsCategories.DeleteCategory;

public class DeleteCategory_Steps {
    @Steps
    DeleteCategory deleteCategory;

    @Given("I set the API endpoint to delete a category by ID")
    public void setAPIEndpointDeleteCategoryByID(){
        deleteCategory.setAPIEndpointDeleteCategoryByID();
    }

    @When("I send a request to delete the category by ID")
    public void sendRequestDeleteCategory(){
        deleteCategory.sendRequestDeleteCategory();
    }

    @Then("I receive a null data that indicate category has been deleted")
    public void receiveNullDataDeletedCategory(){
        deleteCategory.receiveNullDataDeletedCategory();
    }
}
