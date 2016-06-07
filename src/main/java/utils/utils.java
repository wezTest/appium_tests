package Utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class utils {



    public static void clickElement(WebDriver driver, By locator) {
        waitForVisibilityOf(driver, locator);
        driver.findElement(locator).click();
    }

    public static void sendKeys(WebDriver driver, By locator, String text) {
        waitForVisibilityOf(driver, locator);
        driver.findElement(locator).sendKeys(text);
    }

    public static void waitForVisibilityOf(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void scrollAndClick(AndroidDriver driver, String text) {
        driver.scrollTo(text).click();
    }

    public static void waitForClickabilityOf(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
