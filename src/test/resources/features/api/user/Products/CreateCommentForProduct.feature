@CreateComment
Feature: Create a Comment for product
    As a User
    I want to create a comment for a product
    So that I can evaluate the product based on user feedback

    @CreateComment-ValidID
    Scenario: Create a comment with specific ID
        Given I set API endpoint to create a comment for a product
        When I send a request to create a comment for a product
        And I should receive a status code of 200
        Then Then I receive a comment that I have made