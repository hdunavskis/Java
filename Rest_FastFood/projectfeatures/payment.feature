Feature: The Payment page
 As a customer who has placed an order I want to be able to pay for the food.

Background:
	Given A customer has placed an order
  Scenario Outline: The customer should be able to pay for the food
   When the customer clicks on the "<button>" pay
   Then the customer should see a <amount> to pay
   And make a payment by clicking the "<confirm>" payment
   
   Examples:
   |button|amount|confirm|
   |Pay|10|confirmPayment|

  