package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.commonMethods;

public class checkOutPage extends commonMethods {

    @FindBy(xpath = "(//input[@id='customer-email'])[1]")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='firstname']")
    public WebElement firstNameField;

    @FindBy(xpath = "//input[@name='lastname']")
    public WebElement lastNameField;

    @FindBy(xpath = "//input[@name='street[0]']")
    public WebElement streetAddressField;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement cityField;

    @FindBy(xpath = "//select[@name='region_id']")
    public WebElement stateField;

    @FindBy(xpath = "//input[@name='postcode']")
    public WebElement zipcodeField;

    @FindBy(xpath = "//select[@name='country_id']")
    public WebElement countryField;

    @FindBy(xpath = "//input[@name='telephone']")
    public WebElement phoneNumberField;


    @FindBy(xpath = "//input[@name='ko_unique_1']")
    public WebElement zeroDollarRadioBtn;

    @FindBy(xpath = "//input[@name='ko_unique_2']")
    public WebElement fiveDollarRadioBtn;

    @FindBy(xpath = "//button[@data-role='opc-continue']")
    public WebElement nextButton;


    public checkOutPage() {
        PageFactory.initElements(driver, this);
    }
}



