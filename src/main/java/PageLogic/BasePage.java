package PageLogic;

import org.openqa.selenium.WebDriver;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
