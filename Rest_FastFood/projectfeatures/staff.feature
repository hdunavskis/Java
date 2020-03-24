Feature: The Kitchecn Staff page
  As a kitchen staff I want to be able to see and approve all orders

  Background: 
    Given A kitchen staff is logged in and there are orders

  Scenario: The kitchen staff should be able to see all orders
    Then the kitchen staff should see all orders

  Scenario: The kitchen staff should be able to mark orders as ready
    When orders are ready the kitchen staff selects the ready button
    Then order is removed from the list and the user should receive a notification
