package PageLogic;


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
        sendKeys(driver, PageLocators.SignUpPage.txtFirstName(), text);
        return this;
    }

    public SignUpPage populateLastName(String text) {
        sendKeys(driver, PageLocators.SignUpPage.txtLastName(), text);
        return this;
    }

    public SignUpPage populateEmail(String text) {
        sendKeys(driver, PageLocators.SignUpPage.txtEmail(), text);
        return this;
    }

    public SignUpPage populatePassword(String text) {
        sendKeys(driver, PageLocators.SignUpPage.txtPassword(), text);
        return this;
    }

    public SignUpPage clickConfirm() {
        clickElement(driver, PageLocators.SignUpPage.btnConfirm());
        return this;
    }

    public boolean completeSignUp(String firstName, String lastName, String email, String password) {
        populateFirstName(firstName).populateLastName(lastName).populateEmail(email).populatePassword(password).clickConfirm();
        return true;
    }
}
