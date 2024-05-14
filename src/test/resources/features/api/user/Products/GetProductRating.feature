@GetProduct-Rating
Feature: Get Product Rating
    As an Admin
    I want to retrieve the rating of a specific product
    So that I can analyze its performance and make informed decisions

    @GetProduct-Rating-ValidID
    Scenario: Get Product Rating with valid ID
        Given I set API endpoint to get product rating with specific ID
        When I send a request to get product rating with specific ID
        And I should receive a status code of 200
        Then I receive an product rating data from specific ID

    @GetProduct-Rating-InvalidID
    Scenario: Get Product Rating with invalid ID
        Given I set API endpoint to get product rating with invalid ID
        When I send a request to get product rating with invalid ID
        And I should receive a status code of 200
        Then I receive a rating data of 0