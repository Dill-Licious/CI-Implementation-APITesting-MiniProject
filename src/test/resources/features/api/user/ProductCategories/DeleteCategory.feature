Feature: Delete a Category by ID
    As a Admin
    I want to delete a category by its ID
    So that I can remove unnecessary categories from the system

    Scenario: Delete a category with valid ID
        Given I set the API endpoint to delete a category by ID
        When I send a request to delete the category by ID
        And I should receive a status code of 200
        Then I receive a null data that indicate category has been deleted
