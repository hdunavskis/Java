Feature: The order page
	As a logged in customer I want to order food

  Background:
  	Given the user on the menu page
  	
  Scenario Outline: the user should be able to order food
    When the user clicks on the food
    And the modal opens
    Then the user can place a new "<order>"
    
  Examples:
  |order|
  |Order| 
 