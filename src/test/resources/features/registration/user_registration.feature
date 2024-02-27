@registration
Feature: User Registration

  Scenario Outline: User Registraion with valid credentials

    Given The user has valid credentials as "<client_name>" and "<client_email>"
    When The user sends POST request to "/api-clients"
    Then The response status code should be 201
    And The response access token is not empty
    Examples:
      | client_name     | client_email                 |
      | Gurkan Serteser | gurkan.serteser126@gmail.com |

  Scenario Outline: User Registration with invalid credentials

      Given The user has valid credentials as "<client_name>" and "<client_email>"
      When The user sends POST request to "/api-clients"
      Then The response status code should be 400

      Examples:
        | client_name     | client_email              |
        | Gurkan Serteser |                           |
        |                 | gurkan.serteser2gmail.com |

  Scenario Outline: User Registration with invalid endpoint

    Given The user has valid credentials as "<client_name>" and "<client_email>"
    When The user sends POST request to "/api-client"
    Then The response status code should be 404

    Examples:
      | client_name     | client_email               |
      | Gurkan Serteser | gurkan.serteser2@gmail.com |