Feature: Add a product to shopping cart

  @wip
  Scenario: Add a laptop to shopping cart
    Given I am already log in
    And I chose categories "Laptops"
    And I chose a product "MacBook air"
    When I add the product to shopping cart
    And I chose the option "Cart"
    Then I should see name of the product "MacBook air"