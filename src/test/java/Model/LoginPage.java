package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class LoginPage extends BasePage {

        @FindBy(xpath = "//input[@id='user_email']")
        private WebElement emailField;

        @FindBy(xpath = "//input[@id='user_password']")
        private WebElement passwordField;

        @FindBy(xpath = "//button[normalize-space()='Log In']")
        private WebElement loginButton;

        @FindBy(xpath = "//div[@class='page-header_title']")
        private WebElement dashboardElement;


        @FindBy(xpath = "//span[@class='status-button_text']")
        private WebElement errorMessageLogin;


        // Constructor
        public LoginPage(WebDriver driver) {
            super(driver);
        }


        public LoginPage enterEmail(String email) {
            getWait5().until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
            return this;
        }

        public LoginPage enterPassword(String password) {
            getWait5().until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
            return this;
        }

        public LoginPage clickLogin() {
            getWait5().until(ExpectedConditions.elementToBeClickable(loginButton)).click();
            return this;
        }

        public boolean isLoginSuccessful() {
            return getWait5()
                    .until(ExpectedConditions.visibilityOf(dashboardElement))
                    .isDisplayed();
        }

        public boolean isLoginEmailFailed() {
            return getWait5()
                    .until(ExpectedConditions.visibilityOf(errorMessageLogin))
                    .isDisplayed();
        }


    }
