package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.pageInitializer;
import java.time.Duration;

public class commonMethods extends pageInitializer {
    public static WebDriver driver;

    public static void openBrowserAndNavigateToURL() {

        //
        configurationReader.readProperties(constants.CONFIG_PATH);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Calling the 'getProperty' method in which will get the value of the key "URL" which is the link
        driver.get(configurationReader.getProperty("URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        intializePageObjects();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void sendText(String text, WebElement element) {
        waitForClickability(element);
        element.clear();
        element.sendKeys(text);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait;
    }


    public static void waitForClickability(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForClickability(element);
        element.click();
    }

    public static void selectFromDropdown(WebElement dropDown, String visibleText) {
        Select sel = new Select(dropDown);
        sel.selectByVisibleText(visibleText);
    }

    public static void actionClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }
}




