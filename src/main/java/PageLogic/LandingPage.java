package PageLogic;

import org.openqa.selenium.WebDriver;

import static Utils.utils.clickElement;


/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class LandingPage extends BasePage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public LoginOptions clickLogin() {
        clickElement(driver, PageLocators.locators.btnlogin());
        return new LoginOptions(driver);
    }
}
