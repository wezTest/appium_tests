package PageLocators;

import org.openqa.selenium.By;

/**
 * Created by wesley.smyth on 02/06/2016.
 */
public class SignUpPage {
    public static By txtFirstName() {
        return By.id("com.bt.bms:id/edtFirstName");
    }

    public static By txtLastName() {
        return By.id("com.bt.bms:id/edtLastName");
    }

    public static By txtEmail() {
        return By.id("com.bt.bms:id/edtEmailId");
    }

    public static By txtPassword() {
        return By.id("com.bt.bms:id/edtPassword");
    }

    public static By btnConfirm(){
        return By.id("com.bt.bms:id/action_icon");
    }
}
