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
        sendKeys(locators.txtFirstName(),text);
        return this;
    }

    public SignUpPage populateLastName(String text) {
        sendKeys(locators.txtLastName(),text);
        return this;
    }

    public SignUpPage populateEmail(String text) {
        sendKeys(locators.txtEmail(),text);
        return this;
    }

    public boolean completeSignUp(String firstName, String lastName, String email, String password) {
        populateFirstName(firstName).populateLastName(lastName).populateEmail(email);
        return true;
    }

//    public HomePage loginSuccessfully() {
//        populateFirstName().populateLastName() return new HomePage(driver)
//    }
//
//    public boolean verifyAll

}
