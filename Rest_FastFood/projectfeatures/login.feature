Feature: The Login Page
  			As a regisred customer I want to
  			login to the application

  Background: 
    Given the user is on the login page

  Scenario Outline: the user should be able to login
    When a user enters "<username>" and "<password>"
    And clicks on the login button
    Then the user should be logged in "<title>"

    Examples: 
      | username | password | title     |
      | customer | password | My Orders |

  Scenario Outline: the user should not be able to login with the wrong password
    							or username

    When a user enters "<username>" and "<password>"
    And clicks on the login button
    Then the user should get  "<message>" authentication failed

    Examples: 
      | username | password | message                |
      | test     | password | Authentication failed! |
