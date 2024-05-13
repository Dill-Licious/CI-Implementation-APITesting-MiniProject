Feature: Get a Product Comment
    As an Admin
    I want to retrieve a specific product comment
    So that I can review and respond to user feedback effectively

    Scenario: Get a Product Comment with valid ID
        Given I set API endpoint to get a product comment with specific ID
        When I send a request to get product comment with specific ID
        And I should receive a status code of 200
        Then I receive the comment data form ID that I am looking for