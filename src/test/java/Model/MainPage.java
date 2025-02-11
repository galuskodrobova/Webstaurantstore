package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(css = "div[class='static-nav'] a[class='nav-link nav-link--text w-inline-block'] div")
    private WebElement signIn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public SignInPage navigateToSignIn() {
        getWait5().until(ExpectedConditions.elementToBeClickable(signIn)).click();
        return new SignInPage(getDriver());
    }

}

