Feature: The MyOrder page
 As a customer who has placed an order I want to be able to cancel it.

Background:
	Given A customer has placed an order
  Scenario Outline: The customer should be able to cancel the order
   When the customer clicks on the "<button>" cancel
   Then the customer should see a "<confirmation>" message
   And approving the message the order <id> is removed
   
   Examples:
   |button|confirmation|id|
   |cancel|Are you sure you want to cancel?|1|

  Scenario Outline: The customer should be able to not to confirm the order cancelation
   When the customer clicks on the "<button>" cancel
   Then the customer should see a "<confirmation>" message
   And b the message the order <id> is removed
   
   Examples:
   |button|confirmation|id|
   |cancel|Are you sure you want to cancel?|1|

  