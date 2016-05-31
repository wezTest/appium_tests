package Tests;

import PageLogic.LandingPage;
import PageLogic.SignUpPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wesley.smyth on 26/05/2016.
 */
public class appiumTests {

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

   @org.testng.annotations.Test
    public void firstTest() {
        LandingPage test1 = new LandingPage(driver);
        boolean completion = test1.clickLogin().clickSignUp().completeSignUp("test", "test", "test", "test");
        Assert.assertTrue(completion);

       test1.clickLogin().clickSignUp().populateFirstName("gersy");


        //utils.clickElement(driver, locators.btnlogin());
        //utils.clickElement(driver, locators.btnSignUp());
        //int size = driver.findElements(By.className("android.widget.EditText")).size();
        // System.out.println(size);

       /* Utils.Utils.sendKeys(PageLocators.PageLocators.txtFirstName(),driver,"Wesley");
        Utils.Utils.sendKeys(PageLocators.PageLocators.txtLastName(),driver,"Smyth");
        Utils.Utils.sendKeys(PageLocators.PageLocators.txtEmail(),driver,"test@test.com");*/

        //SignUpPage page = new SignUpPage(driver).populateFirstName("Wesley").populateLastName("Smyth");


    }
}
