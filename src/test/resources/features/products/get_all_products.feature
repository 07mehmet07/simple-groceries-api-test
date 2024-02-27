@product
Feature: Get all products

  Scenario Outline: Get all products with category parameter

    Given The user choose query parameter "category" as "<category>"
    When The user sends to GET request to "/products"
    Then The response status code should be 200
    And The list of products should only contain "<category>"
    Examples:
      | category |
      | candy    |
      | dairy    |

    Scenario Outline: Get all products with available parameter
      Given The user choose query parameter "available" as "<available>"
      When The user sends to GET request to "/products"
      Then The response status code should be 200
      And The list of products should only contain "<available>" for stock
      Examples:
        | available |
        | true      |
        | false     |