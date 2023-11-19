Feature: Products In LUMA


  Scenario: Adding Products to cart and placing order
    Given User is navigated to the Homepage
    And User searches "Mens sweatshirt" on the search bar
    And User clicks on Mach Street Sweatshirt
    And User picks Medium Red Sweatshirt, Extra Small Blue Sweatshirt, Large Black Sweatshirt, verifies all products are placed into cart
    When User proceeds to checkout
    And User fills out important information needed for order to be placed
      | email                | FN     | LN      | Street        | City    | State    | Zip   | Country       | PhoneNumber |
      | abracadabra@test.com | George | Ramirez | Ford W Street | Chicago | Illinois | 22143 | United States | 5619870087  |
    Then User clicks on place order and has successfully bought products in LUMA

