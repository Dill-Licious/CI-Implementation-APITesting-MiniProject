@GetAllProducts
Feature: Get all products
    As a user
    I want to get all data products
    So that I can view full list of the products

    #Positive Scenario
    @GetAllProducts-Valid
    Scenario: As a user I can get all data products
        Given I set the API endpoint to retrieve all data products from Alta Shop API
        When I send a request to retrieve all data products
        And I should receive a status code of 200
        Then I should receive valid data for all products