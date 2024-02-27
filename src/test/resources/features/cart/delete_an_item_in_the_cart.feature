@cart
Feature: Delete an item from the cart

  Background:
    Given The endpoint is accessed
    When The user sends POST request to "/carts"
    And The response cart id can not be empty
    And The product with "3674" and the created cart are available
    And The user sends POST request to endpoint
    And The response item id can not be null

  Scenario: Deletion of the product from the cart
    Given The endpoint is accessed
    When The user sends DELETE request to endpoint
    Then The response status code should be 204


