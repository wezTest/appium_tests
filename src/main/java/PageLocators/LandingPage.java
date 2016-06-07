package PageLocators;

import org.openqa.selenium.By;

/**
 * Created by wesley.smyth on 02/06/2016.
 */
public class LandingPage {

    public static By btnlogin() {
            return By.id("com.bt.bms:id/btnLogin");
        }

    public static By btnSkip() {
        return By.id("com.bt.bms:id/btnNoThanks");
    }
}
