package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

    public class EquipmentServicesPage extends BasePage {

        // Locators for the form fields and buttons
        @FindBy(xpath = "//input[@id='business_name']")
        private WebElement businessNameField;

        @FindBy(xpath = "//input[@id='PhoneNumber']")
        private WebElement phoneField;

        @FindBy(xpath = "//input[@id='email_address']")
        private WebElement emailField;

        @FindBy(css = "button[type='submit']")
        private WebElement sendMessageButton;

        @FindBy(css = ".success-message") // Replace with actual locator for success message if known
        private WebElement successMessage;

        // Constructor
        public EquipmentServicesPage(WebDriver driver) {
            super(driver);
        }

        // Method to input business name
        public EquipmentServicesPage enterBusinessName(String businessName) {
            getWait5().until(ExpectedConditions.visibilityOf(businessNameField)).sendKeys(businessName);
            return this;
        }

        // Method to input phone number
        public EquipmentServicesPage enterPhoneNumber(String phoneNumber) {
            getWait5().until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phoneNumber);
            return this;
        }

        // Method to input email address
        public EquipmentServicesPage enterEmail(String email) {
            getWait5().until(ExpectedConditions.visibilityOf(emailField)).sendKeys(email);
            return this;
        }

        // Method to click the "Send Message" button
        public EquipmentServicesPage clickSendMessage() {
            getWait5().until(ExpectedConditions.elementToBeClickable(sendMessageButton)).click();
            return this;
        }

        // Method to verify success message
        public boolean isSuccessMessageDisplayed() {
            return getWait5().until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
        }
    }
