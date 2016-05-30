import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wesley.smyth on 26/05/2016.
 */
public class appiumTests {

    AndroidDriver driver;
    DesiredCapabilities cap;

    @Before
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

    @Test
    public void firstTest() {
        utils.clickElement(locators.btnlogin(),driver);
        utils.clickElement(locators.btnSignUp(),driver);

        utils.sendKeys(locators.txtFirstName(),driver,"Wesley");
        utils.sendKeys(locators.txtLastName(),driver,"Smyth");
        utils.sendKeys(locators.txtEmail(),driver,"test@test.com");

    }
}
