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
        clickElement(driver, PageLocators.LandingPage.btnlogin());
        return new LoginOptions(driver);
    }

    public PickRegion clickSkip() {
        clickElement(driver, PageLocators.LandingPage.btnSkip());
        return new PickRegion(driver);
    }
}
