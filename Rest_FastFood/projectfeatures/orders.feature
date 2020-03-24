Feature: The order page
  As a logged in customer I want to order,
  change, cancel and pay for the food.

  Background: 
    Given A user is logged in

  Scenario Outline: A user should be able to order food
    When a user clicks on the pay now button
    Then the user order is submitted "<confirm>"

    Examples: 
      | confirm           |
      | Ceasar salad wrap |

  Scenario Outline: A user should be able to update an order
    When a user clicks on the pay later button
    And then clicks on the change button
    And updates the order "<note>"
    And clicks on the save button
    Then the user order is updated "<updatedOrder>"

    Examples: 
      | note     | updatedOrder |
      | updating | updating     |

  Scenario Outline: The customer should be able to cancel the order
    When a user clicks on the pay later button
    And the customer clicks on the button cancel
    Then the customer should see a "<confirmation>" message
    And approving the message the order is removed

    Examples: 
      | confirmation  |
      | Cancel order? |

  Scenario Outline: The customer should be able to pay for the food
    When a user clicks on the pay later button
    And then clicks on the pay button
    Then the customer should see a "<confirmation>" message
    And approving the message the payment is processed

    Examples: 
      | confirmation                  |
      | Are you sure you want to pay? |
