@Get-Category-ByID
Feature: Get category by ID
    As an Admin
    I want to retrieve a category by its ID
    So that I can view its details

    @Get-Category-ByValidID
    Scenario: Retrieve a category by valid ID
        Given I set the API endpoint to get a category by ID
        When I send a request to get the category by ID
        And I should receive a status code of 200
        Then I should receive the category details including ID, Name, and Description

    @Get-Category-ByInvalidID
    Scenario: Retrieve a category by invalid ID
        Given I set the API endpoint to get a category by invalid ID
        When I send a request to get the category by invalid ID
        And I should receive a status code of 404 Not Found
        Then I should receive an error message indicate record not found