@CreateNewCategory
Feature: Create a New Category
    As a Admin
    I want to create a new category
    So that I can improve product organization and categorization

    @CreateNewCategory-Valid
    Scenario: Create a new category with valid credentials
        Given I set the API endpoint to create a new category
        When I send a request to create a new category
        And I should receive a status code of 200
        Then I receive new category data