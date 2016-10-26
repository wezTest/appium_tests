package Utils;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Created by wesley.smyth on 09/06/2016.
 */
public class gestureUtils {

    public static void swipeYAxis(WebDriver driver, int yDirection) {
        System.out.println("Preparing to swipe on element");
        Dimension windowSize = driver.manage().window().getSize();
        ((MobileDriver)driver).swipe(windowSize.getWidth() /2, windowSize.getHeight() /2, windowSize.getWidth() /2,(windowSize.getHeight() /2) -yDirection,0);
        System.out.println("Swipe complete");
    }
}

