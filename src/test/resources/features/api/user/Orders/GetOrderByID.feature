@GetOrderByID
Feature: Get Order By ID
  As a Admin
  I want to get order by ID
  So that I can view the details of a specific order

  @GetOrderByID-Valid
  Scenario: Get specific order by valid ID
    Given I set the API endpoint to get specific order by ID
    When I send a request to get specific order by ID
    And I should receive a status code of 200
    Then I should receive a data response containing the details of the order