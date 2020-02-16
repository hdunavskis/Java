Feature: The Kitchecn Staff page
 As a kitchen staff I want to be able to see all orders that are placed

Background:
	Given A kitchen staff is on the landing page
Scenario Outline: The kitchec staff should be able to view all orders
  Then the kitchen staff should see all "<orders>"
     
Examples:
  |orders|
  |id|

Scenario Outline: The kitchen staff should be able to confirm orders
When orders are placed
Then the kitchen staff selects the "<confirm>" confirm option

Examples:
|confirm|
|Confirm|

Scenario Outline: The kitchen staff should be able to change status to collect when the order is ready
When order is ready
Then the kitchen staff selects the "<collection>" collection option

Examples:
|collection|
|collection|

Scenario Outline: The system should notify the customer when the order is ready for collection
When the order is ready
Then the user should receive a notification "<ready>" of collection

Examples:
|ready|
|Ready for collection|
  