package Tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by wesley.smyth on 08/06/2016.
 */
public class apiAppTests {

    static AndroidDriver driver;
    DesiredCapabilities cap;

    @BeforeTest
    public void beforeCapabilities() throws MalformedURLException {
        //set app location
        File appDir = new File("Apps");
        File app = new File(appDir, "ApiDemos-debug.apk");

        //set emulator capabilities
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        driver.unlockDevice();
    }

    //test for using items that dont have unique IDs
    @Test
    public void apiTest() {
        String text = "Preference";
        Utils.utils.scrollAndClick(driver, text);
        List<WebElement> links = Utils.utils.listOfElements(driver, PageLocators.ApiPageLinks.APILinks());

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
        }
        System.out.println(links.get(8).getText());
    }

    @Test
    public void apiTestGestures() {
        String text = "App";
        Utils.utils.scrollAndClick(driver, text);

        MobileElement gesture = (MobileElement) driver.findElement(By.className("android.widget.TextView")); //cast to appium function
        gesture.swipe(SwipeElementDirection.UP, 1000);
        gesture.tap(1,100);
        gesture.zoom();
    }

    @Test
    public void apiTestTouchActions() {
        List<WebElement> links = Utils.utils.listOfElements(driver, PageLocators.ApiPageLinks.APILinks());
        links.get(2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(links.get(2));

        //capabilities functions
        System.out.println(driver.isLocked());
        System.out.println(driver.getContext());
        driver.closeApp();
    }


}
