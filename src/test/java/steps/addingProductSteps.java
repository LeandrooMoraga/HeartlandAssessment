package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utils.commonMethods;
import java.util.List;
import java.util.Map;

public class addingProductSteps extends commonMethods {

    @Given("User is navigated to the Homepage")
    public void user_is_navigated_to_the_homepage() {
        // method to navigate to the browser, no URL is being shown
        openBrowserAndNavigateToURL();
    }

    @Given("User searches {string} on the search bar")
    public void user_searches_on_the_search_bar(String productSearch) {
        sendText(productSearch, homePage.searchBar);
        click(homePage.searchButton);
    }

    @Given("User clicks on Mach Street Sweatshirt")
    public void user_clicks_on_mach_street_sweatshirt() {
        click(menSweatshirtPage.MachSweater);
    }

    @Given("User picks Medium Red Sweatshirt, Extra Small Blue Sweatshirt, Large Black Sweatshirt, verifies all products are placed into cart")
    public void user_picks_medium_red_sweatshirt_extra_small_blue_sweatshirt_large_black_sweatshirt_verifies_all_products_are_placed_into_cart() {
        click(machStreetSweatshirtPage.MButton);
        click(machStreetSweatshirtPage.RedButton);
        click(machStreetSweatshirtPage.AddToCartButton);

        // Verification point if added successfully to cart
        Assert.assertEquals("You added Mach Street Sweatshirt to your shopping cart.", machStreetSweatshirtPage.successfullyAdded.getText());
        click(machStreetSweatshirtPage.XSButton);
        click(machStreetSweatshirtPage.BlueButton);
        click(machStreetSweatshirtPage.AddToCartButton);

        // Verification point if added successfully to cart
        Assert.assertEquals("You added Mach Street Sweatshirt to your shopping cart.", machStreetSweatshirtPage.successfullyAdded.getText());
        click(machStreetSweatshirtPage.LargeButton);
        click(machStreetSweatshirtPage.BlackButton);

        // Try Catch block to handle the exception in which the program won't stop executing mid-way
        try {
            // It needed at least one second of wait so the add to cart button can work again and add the third product
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        click(machStreetSweatshirtPage.AddToCartButton);
        // Verification point if added successfully to cart
        Assert.assertEquals("You added Mach Street Sweatshirt to your shopping cart.", machStreetSweatshirtPage.successfullyAdded.getText());

    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() {
        click(homePage.cartButton);
        click(homePage.proceedCheckoutButton);
    }

    @When("User fills out important information needed for order to be placed")
    public void user_fills_out_important_information_needed_for_order_to_be_placed(io.cucumber.datatable.DataTable checkoutInfo) {
        List<Map<String, String>> data = checkoutInfo.asMaps();

        for (Map<String, String> d : data) {
            sendText(d.get("email"), checkOutPage.emailField);
            sendText(d.get("FN"), checkOutPage.firstNameField);
            sendText(d.get("LN"), checkOutPage.lastNameField);
            sendText(d.get("Street"), checkOutPage.streetAddressField);
            // Thread.sleep(2000);
            // getWait().until(ExpectedConditions.presenceOfElementLocated(By.id(checkOutPage.streetAddressField.toString())));
            sendText(d.get("City"), checkOutPage.cityField);
            selectFromDropdown(checkOutPage.stateField, d.get("State"));
            sendText(d.get("Zip"), checkOutPage.zipcodeField);
            selectFromDropdown(checkOutPage.countryField, d.get("Country"));
            sendText(d.get("PhoneNumber"), checkOutPage.phoneNumberField);
            click(checkOutPage.zeroDollarRadioBtn);
            click(checkOutPage.nextButton);
        }

    }

    @Then("User clicks on place order and has successfully bought products in LUMA")
    public void user_clicks_on_place_order_and_has_successfully_bought_products_in_luma() {
        try {
            Thread.sleep(2000);

            // Simple click didn't work, so I used Action class click
            actionClick(reviewPaymentPage.placeOrderButton);

            // A lot of loading is happening before it goes to the Successful page in
            // which it'll not get the correct Web Element to do Assertions
            Thread.sleep(2000);
            // Verifying point if we actually did a successful purchase to the products
            Assert.assertEquals("Thank you for your purchase!", reviewPaymentPage.successfulPurchaseMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        closeBrowser();
    }


}
