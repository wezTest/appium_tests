package PageLogic;

import org.openqa.selenium.WebDriver;

import static Utils.utils.*;

/**
 * Created by wesley.smyth on 07/06/2016.
 */
public class PickRegion extends BasePage {

    public PickRegion(WebDriver driver) {
        super(driver);
    }

    public PickRegion dismissPopup(){
        clickElement(driver, PageLocators.PickRegion.btnDismiss());
        return this;
    }

    public boolean confirmDismissPopup() {
        clickElement(driver, PageLocators.PickRegion.btnDismiss());
        return true;
    }
}
