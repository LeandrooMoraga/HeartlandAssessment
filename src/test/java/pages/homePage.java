package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class homePage extends commonMethods {


    // I'm following Page Object Model (POM) design approach, all Web elements for a particular page stays in a class
    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@title='Search']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@class='action showcart']")
    public WebElement cartButton;

    @FindBy(xpath = "//button[@id='top-cart-btn-checkout']")
    public WebElement proceedCheckoutButton;


    public homePage() {
        // initializing the Web Elements
        PageFactory.initElements(driver, this);
    }

}
