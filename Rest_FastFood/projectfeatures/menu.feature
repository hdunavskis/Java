Feature: The landing/menu page
  				As a logged in customer I want to 
  				see menu

  Background: 
    Given A user is on the landing page

  Scenario Outline: the user shoud be able to see the menu
    When a user opens the website "<title>"
    Then the menu can be visible "<menu>"

    Examples: 
      | title         | menu |
      | Rest_FastFood | Menu |
