@First
Feature: Login API- Get all the users
  Scenario Outline: Verify the resposne for all the users
    Given The request with all headers
    When get the service "<service>"
    Then validate the response code as 200
    And retrieve the total value
    Examples:
      | service |
      |/api/users?page=2|