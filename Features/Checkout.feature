#Author:  msyedalam@outlook.com

Feature: checkout functionality on WahooFitness website

  @tag
  Scenario: checkout functionality on WahooFitness website decline payment
    Given I want to launch wahoofitness webapp
    And I select two product and add to the cart
    When I remove a product from the cart
    Then I see a popup with message is displayed
    And I accept the popup
    When I click on edit cart link
    Then I cart page is displayed
    And I update quantity of the item in the cart
    And I click on update cart
    Then I see the prices reflect the change
    When I click on checkout button
    Then I see checkout details page
    When I click on place order button
    Then I Error messages appear
    When I change shipping method to express shipping
    | 4111111111111111 | 0824 | 111 |
    When I enter email name address phone
    | test@test.com | Test | Tester | Comandante Izarduy 67 | Barcelona | Spain | Barcelona | 08940 | 5555555555 |
    And I click on place order button
    Then I see the payment id declined with error message
