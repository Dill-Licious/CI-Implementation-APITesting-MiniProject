Feature: Create a new order
    As a User
    I want to create a new order
    So that I can buy a product from Alta Shop

    Scenario: Create a new order with valid credentials
        Given I set the API endpoint to create a new order
        When I send a request to create a new order with valid credentials
        And I should receive a status code of 200
        Then I should receive confirmation data about the product that I bought