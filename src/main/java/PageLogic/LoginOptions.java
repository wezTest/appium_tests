package PageLogic;

import org.openqa.selenium.WebDriver;

import static Utils.utils.clickElement;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class LoginOptions extends BasePage {

    public LoginOptions(WebDriver driver) {
        super(driver);
    }

    public SignUpPage clickSignUp() {
        clickElement(driver, PageLocators.LoginOptions.btnSignUp());
        return new SignUpPage(driver);
    }

}
