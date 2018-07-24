
@tag
Feature:Verify the product page filter is working properly

  @tag1
  Scenario: Verify the Product page Lowest first is working properly
    Given User is on Application homepage
    When  User click on homepage search button and supplies "Casual dress"
    And   Clicks on the search box
    Then  Search results page should be displaying products 
    When  User clicks on the User by and selects "Price: Lowest first"
    Then  Products should be displayed in Ascending order of price
