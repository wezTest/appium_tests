package PageLogic;


import PageLocators.locators;
import org.openqa.selenium.WebDriver;

import static Utils.utils.*;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class SignUpPage extends BasePage {


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public SignUpPage populateFirstName(String text) {
        sendKeys(driver, locators.txtFirstName(), text);
        return this;
    }

    public SignUpPage populateLastName(String text) {
        sendKeys(driver, locators.txtLastName(), text);
        return this;
    }

    public SignUpPage populateEmail(String text) {
        sendKeys(driver, locators.txtEmail(), text);
        return this;
    }

    public SignUpPage populatePassword(String text) {
        sendKeys(driver, locators.txtPassword(), text);
        return this;
    }

    public boolean completeSignUp(String firstName, String lastName, String email, String password) {
        populateFirstName(firstName).populateLastName(lastName).populateEmail(email).populatePassword(password);
        return true;
    }
}
