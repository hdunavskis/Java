Feature: The MyOrders page
	As a customer who has placed an order I want to be able
	to update it.

  Scenario Outline: the customer shoud be able to see the order
    When the customer is on the MyOrders page
    Then the customer should see all the "<orders>" placed by the customer  
		    
  Examples:
  |orders|
  |My Orders|

 Scenario Outline: the user should be able to update the orders
    When the customer clicks on the "<button>" update
		Then the customer should see the "<message>" Successfull update
    
  Examples:
  |button|message|
  |Update|Successfull update|

 Scenario Outline: the user should not be able to update the order after it 
 	is confirmed.
    When the customer clicks on the "<button>" update
    Then the customer should see the "<message>" Update is not possible
    
  Examples:
  |button|message|
  |Update| Update is not possible|
 