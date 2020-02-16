Feature: The landing/menu page
  				As a logged in customer I want to 
  				see menu

  Scenario Outline: the user shoud be able to see all foods which
  					are available for order.
    When the user is on the landing page
    Then the menu "<title>" should be visible 
    And the food "<list>" should be visible
    
  Examples:
  |title|list|
  |Menu|Burger|

 Scenario Outline: the user should be able to order food
    When the user clicks on the food
    Then the user can place a new "<order>"
    
  Examples:
  |order|
  |Order| 
 