Feature: The landing/menu page
  				As a logged in customer I want to 
  				see menu
Background:
Given A user is on the landing page
  Scenario: the user shoud be able to see the menu
 
    When a user selects the menu option on the nav bar
    Then the menu page is displayed 
    And  all available food
    