@Second
Feature: Login API user submission

  Scenario Outline: Verify the post submission
    Given The request with all headers
    When post the request "<service>"
    Then validate the response code as 200
    Examples:
      | service       |
      | /api/register |

