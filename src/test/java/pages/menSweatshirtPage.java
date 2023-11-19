package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class menSweatshirtPage extends commonMethods {

    @FindBy(xpath = "(//strong[@class='product name product-item-name']/following::a)[3]")
    public WebElement MachSweater;


    public menSweatshirtPage() {
        PageFactory.initElements(driver, this);
    }
}
