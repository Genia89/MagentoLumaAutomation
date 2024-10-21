@wip
Feature: Validate "What's New" products and prices

  Scenario: Validate products and prices from "What's New" section
    Given the user is on the Luma homepage
    When the user clicks on the "What's New" link
    Then the following products should be displayed:
      | productName            | price |
      | Wayfarer Messenger Bag | 45.00 |
      | Overnight Duffle       | 45.00 |
      | Summit Watch           | 54.00 |
      | Dash Digital Watch     | 92.00 |
    And the product prices should match the JSON data
