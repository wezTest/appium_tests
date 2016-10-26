package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by wesley.smyth on 16/06/2016.
 */
public class seleniumWebTests {

    WebDriver driver;

    @BeforeTest
    public void beforeBrowser(){
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
    }

    @AfterTest
    public void afterBrowser(){
        driver.close();
    }

    @Test
    public void clickElement(){
        driver.findElement(By.id("submitButton")).click();
        //Utils.Utils.clickElement(driver, By locator);
    }

    @Test
    public void getTextFromDropdown(){
        String dropdown = driver.findElement(By.tagName("select")).getText();
        System.out.println(dropdown);
    }

    @Test
    public void selectFromDropDown(){
//        Select dropdown = new Select(driver.findElement(By.id("Carlist")));//doesnt exist
//        dropdown.selectByVisibleText("Audi");

        Select listbox = new Select(driver.findElement(By.xpath("//select[@name='FromLB']")));
        listbox.selectByValue("Italy");
        listbox.selectByIndex(1);
    }

    @Test
    public void sendKeysToTextField(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);//implicit wait
        driver.findElement(By.name("fname")).sendKeys("Hello");
    }

    @Test
    public void waitForElement() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='timeLeft']"), "Time left: 7 seconds"));
        //Utils.Utils.waitForVisibilityOf(driver, By Locator);
    }

    @Test
    public void browserDetails(){
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void executeScript(){
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        String url = (String)javascript.executeScript(("return document.domain"));
        System.out.println(url);
        javascript.executeScript("alert('Test Case is starting');");
    }


}
