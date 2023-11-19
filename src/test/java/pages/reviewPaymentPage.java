package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class reviewPaymentPage extends commonMethods {

    @FindBy(xpath = "//button[@title='Place Order']")
    public WebElement placeOrderButton;
    @FindBy(xpath = "//span[@class='base']")
    public WebElement successfulPurchaseMessage;






    public reviewPaymentPage(){
        PageFactory.initElements(driver,this);
    }
}

