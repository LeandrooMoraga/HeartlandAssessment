package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class machStreetSweatshirtPage extends commonMethods {

    @FindBy(xpath = "//div[text()='XS']")
    public WebElement XSButton;

    @FindBy(xpath = "//div[text()='M']")
    public WebElement MButton;

    @FindBy(xpath = "//div[text()='L']")
    public WebElement LargeButton;

    @FindBy(xpath = "//div[@option-label='Black']")
    public WebElement BlackButton;

    @FindBy(xpath = "//div[@option-label='Red']")
    public WebElement RedButton;

    @FindBy(xpath = "//div[@option-label='Blue']")
    public WebElement BlueButton;

    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    public WebElement AddToCartButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement successfullyAdded;


    public machStreetSweatshirtPage() {
        PageFactory.initElements(driver, this);
    }
}



