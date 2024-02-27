@product
Feature: Get a product

  Scenario Outline: Get a product with valid product id
    Given The endpoint is accessed
    When The user sends to GET request to "/products/" with "<id>"
    Then The response status code should be 200
    And The response id should be the same with specified "<id>"
    Examples:
      | id   |
      | 4643 |
      | 4646 |

    Scenario Outline: Get a product with invalid product id
      Given The endpoint is accessed
      When The user sends to GET request to "/products/" with "<id>"
      Then The response status code should be 404
      Examples:
        | id          |
        | 4644        |
        | 34432543545 |
