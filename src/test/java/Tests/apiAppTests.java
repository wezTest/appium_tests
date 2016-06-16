package Tests;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

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

    AndroidDriver driver;
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

        //System.out.println(driver.isLocked());
        //System.out.println(driver.getContext());
        //driver.closeApp();
    }

    //test for using items that dont have unique IDs
    @Test
    public void apiTest() {
        String text = "Preference";
        String findValue = "4. Default values";

        Utils.utils.scrollAndClick(driver, text);
        List<WebElement> links = Utils.utils.listOfElements(driver, PageLocators.ApiPageLinks.APILinks());

        for (int i = 0; i < links.size(); i++) {
            System.out.println(links.get(i).getText());
            if (links.get(i).getText().contains(findValue));
            {
                System.out.println("FOUND IT!");
                break;
            }
        }
    }

    @Test
    public void apiTestGestures() {
        String text = "App";
        Utils.utils.scrollAndClick(driver, text);

        // MobileElement gesture = (MobileElement) driver.findElement(By.className("android.widget.TextView")); //cast to appium function
        // gesture.swipe(SwipeElementDirection.UP, 1000); //swipe commands
        //gesture.zoom(); //pinch zoom

        //use the utilsGesture
        int yAxis = 50;
        Utils.gestureUtils.swipeYAxis(driver, yAxis);
    }

    @Test
    public void apiTestTouchActions() {
        List<WebElement> links = Utils.utils.listOfElements(driver, PageLocators.ApiPageLinks.APILinks());
        links.get(2);

        //create driver for gestures
        TouchAction touchAction = new TouchAction(driver);

        //always use .perform() after commands.
        touchAction.tap(links.get(2)).perform(); //tap an item
        touchAction.longPress(links.get(2)).perform(); //long press
    }


}
