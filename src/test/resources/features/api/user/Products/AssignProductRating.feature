@AssignProductRating
Feature: Assign a Product Rating
    As a User
    I can assign a product rating
    So that other users can consider before buying the product

    @AssignProductRating-ValidID
    Scenario: Assign a product rating valid ID
        Given I set API endpoint to assign a rating to specific product
        When I send a request to assign a rating to specific product
        And I should receive a status code of 200
        Then I receive an update data rating from the product