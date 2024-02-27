@order
Feature: Create a new order

  Background:
    Given The user has valid credentials as "Özgür Kartal" and "ozgur11@gmail.com"
    When The user sends POST request to "/api-clients"
    And The response access token is not empty
    And The user sends POST request to "/carts"
    And The response cart id can not be empty
    And The product with "3674" and the created cart are available
    And The user sends POST request to endpoint
    And The response item id can not be null

  Scenario: Create a new order with valid authorizathion
    Given The user has cart id and customer name as "Özgür Kartal"
    When The user sends POST request to available endpoint
    Then The response status code should be 201
    And The response order id can not be null
