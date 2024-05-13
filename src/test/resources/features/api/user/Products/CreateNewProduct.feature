Feature: Create a new product to Alta Shop
    As a User
    I want to create a new product
    So that I can add the newest product

    #Positive Scenario
    Scenario: Add a new product with valid credentials
        Given I set the API endpoint to add a new product to Alta Shop API
        When I send a request to add a new product
        And I should receive a status code of 200
        Then I should see my product successfully added

