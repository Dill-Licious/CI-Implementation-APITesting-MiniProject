@DeleteProduct
Feature: Delete a specific product
    As a Admin
    I want to delete a specific product
    So that I can can maintain whether the product is still available or not

    @DeleteProduct-ValidID
    Scenario: Delete product with ID 2
        Given I set the API endpoint to delete a specific product by ID
        When I send a request to delete a specific product by ID
        And I should receive a status code of 200
        Then I receive a null data that indicate product has been deleted