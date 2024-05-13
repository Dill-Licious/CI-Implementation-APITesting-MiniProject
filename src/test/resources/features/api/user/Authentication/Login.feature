Feature: Login to Alta Shop
  As a User
  I want to login
  So that I can shopping into Alta Shop

  #Positive scenario
  Scenario: As a User I can login with valid credentials
    Given I set the API endpoint to login into Alta Shop
    When I send a request to login into Alta Shop with valid credentials
    And I should receive a status code of 200
    Then I should receive a data confirmation that indicating success login

  # Negatif Scenario
  Scenario: As a User I cannot login with invalid email
    Given I set the API endpoint to login into Alta Shop
    When I send a request to login into Alta Shop with invalid email
    And I should receive a status code of 400 Bad Request
    Then I receive an error message indicate record not found

  Scenario: As a User I cannot login with invalid password
    Given I set the API endpoint to login into Alta Shop
    When I send a request to login into Alta Shop with invalid password
    And I should receive a status code of 400 Bad Request
    Then I receive an error message indicate invalid password

  Scenario: As a User I cannot login with empty data email and password
    Given I set the API endpoint to login into Alta Shop
    When I send a request to login into Alta Shop with empty data email and password
    And I should receive a status code of 400 Bad Request
    Then I receive an error message indicate must filled required field

