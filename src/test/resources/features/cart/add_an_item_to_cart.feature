@cart
Feature: Add an item to cart

  Background:
    Given The endpoint is accessed
    When The user sends POST request to "/carts"
    And The response cart id can not be empty

  Scenario Outline: Add an valid item to cart
    Given The product with "<product_id>" and the created cart are available
    When The user sends POST request to endpoint
    Then The response status code should be 201
    And The response item id can not be null
    Examples:
      | product_id |
      | 4641       |
      | 3674       |