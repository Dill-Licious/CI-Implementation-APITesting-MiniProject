Feature: Get All Categories
  As a user
  I want to get all product categories
  So that I can browse products by category

  Scenario: Get all valid products categories
    Given I set the API endpoint to get all product categories
    When I send a request to get all product categories
    And I should receive a status code of 200
    Then I receive all data product categories