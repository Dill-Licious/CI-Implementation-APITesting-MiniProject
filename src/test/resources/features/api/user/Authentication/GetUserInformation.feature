Feature: Get User Information
    As an Admin
    I want to retrieve information about a user
    So that I can manage user accounts and permissions efficiently

    Scenario: Get user information that success login
        Given I set API endpoint to get user information
        When I send a request to get user information
        And I should receive a status code of 200
        Then I receive user information who has successfully logged in
