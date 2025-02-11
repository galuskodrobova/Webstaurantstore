package Model;

import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }

}
