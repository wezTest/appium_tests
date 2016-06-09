package Tests;

import Common.enumExample;
import PageLocators.LoginOptions;
import PageLogic.LandingPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import static Common.enumExample.MONDAY;

/**
 * Created by wesley.smyth on 26/05/2016.
 */
public class bookMyShowTests {

    static AndroidDriver driver;
    DesiredCapabilities cap;

    @BeforeTest
    public void beforeCapabilities() throws MalformedURLException {
        //set app location
        File appDir = new File("Apps");
        File app = new File(appDir, "com.bt.bms.apk");

        //set emulator capabilities
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.unlockDevice();
    }

    //enum example
    @Test
    public void enumTest() {
        enumExample dayName = MONDAY;
        System.out.println(dayName.getDays());
    }

    //page journey tests
    @Test
    public void firstTest() {
        LandingPage test1 = new LandingPage(driver);
        boolean completion = test1.clickLogin().clickSignUp().completeSignUp("test", "test", "test", "test");
        Assert.assertTrue(completion);
    }

    @Test
    public void secondTest() {
        LandingPage test1 = new LandingPage(driver);
        boolean dismiss = test1.clickSkip().confirmDismissPopup();
        Assert.assertEquals(dismiss, true);
    }

    //appium style tests
    @Test
    public void altSignUpTest() {
        Utils.utils.clickElement(driver, PageLocators.LandingPage.btnlogin());
        Utils.utils.clickElement(driver, LoginOptions.btnSignUp());

        int size = driver.findElements(By.className("android.widget.EditText")).size();
        System.out.println(size);
        List<WebElement> textFields = driver.findElements(By.className("android.widget.EditText"));
        textFields.get(0).sendKeys("appium");
        textFields.get(1).sendKeys("Mobile");
        textFields.get(2).sendKeys("appium@training.com");
        textFields.get(3).sendKeys("password");

        Utils.utils.clickElement(driver, PageLocators.SignUpPage.btnConfirm());
    }
}
