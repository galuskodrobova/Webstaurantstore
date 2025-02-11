package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MyAccountPage extends BasePage {

    @FindBy(xpath = "//label[@for='firstName']")
    private WebElement firstNameLabel;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstNameField;


    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@name='address1']")
    private WebElement addressLine1Field;

    @FindBy(xpath = "//input[@name='address2']")
    private WebElement addressLine2Field;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement cityField;

    @FindBy(xpath = "//select[@name='state']")
    private WebElement stateDropdown;

    @FindBy(xpath = "//input[@name='zip']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = "//button[contains(text(),'Update Information')]")
    private WebElement updateInfoButton;

    @FindBy(xpath = "//div[contains(text(),'Profile updated successfully')]")
    private WebElement updateSuccessMessage;

    @FindBy(xpath = "//button[contains(text(),'Reset Password')]")
    private WebElement resetPasswordButton;

    @FindBy(xpath = "//div[contains(text(),'Reset link sent to your email')]")
    private WebElement resetLinkSuccessMessage;


    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getDriver().getTitle();
    }


    // Verify My Account page is displayed
    public boolean isMyAccountPageDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(firstNameField)).isDisplayed();
    }

    // Get user details
    public String getFirstName() {
        return firstNameField.getAttribute("value");
    }

    public String getLastName() {
        return lastNameField.getAttribute("value");
    }

    public String getEmail() {
        return emailField.getAttribute("value");
    }

    // Update address fields
    public MyAccountPage updateAddress(String newAddress, String city, String zip) {
        getWait5().until(ExpectedConditions.visibilityOf(addressLine1Field)).clear();
        addressLine1Field.sendKeys(newAddress);

        getWait5().until(ExpectedConditions.visibilityOf(cityField)).clear();
        cityField.sendKeys(city);

        getWait5().until(ExpectedConditions.visibilityOf(zipCodeField)).clear();
        zipCodeField.sendKeys(zip);

        updateInfoButton.click();
        return this;
    }

    // Verify update success message
    public boolean isUpdateSuccessful() {
        return getWait5().until(ExpectedConditions.visibilityOf(updateSuccessMessage)).isDisplayed();
    }

    // Reset Password
    public MyAccountPage clickResetPassword() {
        getWait5().until(ExpectedConditions.elementToBeClickable(resetPasswordButton)).click();
        return this;
    }

    // Verify password reset success message
    public boolean isResetLinkSent() {
        return getWait5().until(ExpectedConditions.visibilityOf(resetLinkSuccessMessage)).isDisplayed();
    }


}
