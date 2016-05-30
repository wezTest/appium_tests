import org.openqa.selenium.By;

/**
 * Created by wesley.smyth on 30/05/2016.
 */
public class locators {

    public static By btnlogin() {
            return By.id("com.bt.bms:id/btnLogin");
        }

    public static By btnSignUp() {
        return By.id("com.bt.bms:id/btnSignUp");
    }

    public static By txtFirstName() {
        return By.id("com.bt.bms:id/edtFirstName");
    }

    public static By txtLastName() {
        return By.id("com.bt.bms:id/edtLastName");
    }

    public static By txtEmail() {
        return By.id("com.bt.bms:id/edtEmailId");
    }
}
