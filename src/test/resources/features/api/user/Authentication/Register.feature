@Register
Feature: Register to Alta Shop
    As a User
    I want to register
    So that I can login into Alta Shop

    #Scenario positif
    @Register-Valid
    Scenario: Register with valid credentials
        Given I set the API endpoint to register into Alta Shop
        When I send a request to register into Alta Shop with valid credentials
        And I should receive a status code of 200
        Then I should receive a data confirmation that indicating register success