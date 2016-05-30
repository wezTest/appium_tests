package Common;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

/**
 * Created by wesley.smyth on 24/05/2016.
 */
public class helloworld {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", new File("").getAbsolutePath() + "\\ChromeDriver\\chromedriver" +
                ".exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
