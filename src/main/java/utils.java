import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class utils {

    public static void clickElement(By locator, AndroidDriver driver){
        waitForVisibilityOf(locator, driver);
        driver.findElement(locator).click();
    }

    public static void sendKeys(By locator, AndroidDriver driver, String text){
        waitForVisibilityOf(locator, driver);
        driver.findElement(locator).sendKeys(text);
    }


    public static void waitForVisibilityOf(By locator, AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForClickabilityOf(By locator, AndroidDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
