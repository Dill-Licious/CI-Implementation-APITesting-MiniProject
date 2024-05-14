@GetIndex
Feature: Get Index Hello
  As a User
  I want to retrieve the index page with a greeting message
  So that I can verify that the application is running correctly

  @GetIndex-Valid
  Scenario: Get index with valid greeting message
    Given I set the API endpoint to retrieve the index page that returns a greeting message
    When I send a request to receive greeting message
    And I should receive a status code of 200
    Then I receive a hello message
