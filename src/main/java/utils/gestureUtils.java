package Utils;

import io.appium.java_client.MobileDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/**
 * Created by wesley.smyth on 09/06/2016.
 */
public class gestureUtils {

    public static void swipeYAxis(WebDriver driver, int yDirection) {
        Dimension windowSize = driver.manage().window().getSize();
        int height = windowSize.getHeight();
        int width = windowSize.getWidth();

        //((MobileDriver)driver).swipe(d.getWidth() /2, d.getHeight() /2, d.getWidth() /2, (d.getHeight() /2) -400,0);
        ((MobileDriver)driver).swipe(width / 2, height / 2, windowSize.getWidth(), (windowSize.getHeight() / 2) - yDirection, 0);
    }
}
