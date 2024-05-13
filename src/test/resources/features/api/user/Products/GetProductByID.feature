Feature: Get Product Data by ID
    As a admin
    I want to retrieve specific product information by its ID
    So that I can view specific details of a product

    Scenario: Retrieve a specific product with valid ID
        Given I set API endpoint to get specific product info by ID
        When I send a request to get specific product info by valid ID
        And I should receive a status code of 200
        Then I should receive the product data by its ID