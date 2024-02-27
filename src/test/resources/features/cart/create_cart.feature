@cart
Feature: Create a new cart

  Scenario: Create a new cart
    Given The endpoint is accessed
    When The user sends POST request to "/carts"
    Then The response status code should be 201
    And The response cart id can not be empty
