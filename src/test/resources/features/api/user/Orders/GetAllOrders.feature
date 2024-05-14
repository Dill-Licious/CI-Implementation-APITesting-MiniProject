@GetAllOrders
Feature: Get All Orders
    As an Admin
    I want to retrieve all order data
    So that I can manage and analyze the orders efficiently

    @GetAllOrders-ValidMethod
    Scenario: Get all valid data order at Alta Shop
        Given I set the API endpoint to get all data orders
        When I send a request to retrieve all data orders
        And I should receive a status code of 200
        Then I receive all valid orders data from Alta Shop

    #Negatif Scenario:
    @GetAllOrders-InValidMethod
    Scenario: Get all valid data order with wrong method
        Given I set the API endpoint to get all data orders
        When I send a request with invalid method to retrieve all data orders
        And I should receive a status code of 400 Bad Request
        Then I receive an error message indicate end of file