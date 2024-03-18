package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

    private WebDriver driver;
    protected WebDriverWait wait;

    protected WebDriver getDriver() {
        return driver;
    }

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait5() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 10);
        }

        return wait;
    }
}

