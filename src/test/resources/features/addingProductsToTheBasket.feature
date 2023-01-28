Feature: Adding products and going to payment page

  @addingProductsToTheBasket
  Scenario: Add desired products to the basket and go to payment page
    Given User opens the browser and goes to the home page and searches for the product "iPhone" on the search bar
    When User adds first and last products to the basket
    Then User continues to the payment page as a guest
    And User sees that payment page opens