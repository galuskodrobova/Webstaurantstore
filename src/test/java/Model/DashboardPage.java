package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//div[@class='page-header_title']")
    private WebElement profileHeader;

    @FindBy(xpath = "//div[@class='header-user_fullname']")
    private WebElement petOwnerName;

    @FindBy(xpath = "//div[@class='page-header_subtitle']")
    private WebElement petCount;

    @FindBy(xpath = "//div[@class='pet-count-banner__cue-title']")
    private WebElement incompleteProfileWarning;

    @FindBy(xpath = "//div[@class='pet-profile-list_name']")
    private WebElement petProfileVictor;

    @FindBy(xpath = "//div[@class='pet-profile-list_substatus with_linebreaks']")
    private WebElement pendingChanges;

    @FindBy(xpath = "//button[@class='header-dropdown-menu_button dropdown-toggle']")
    private WebElement profileDropdown;

    @FindBy(xpath = "//a[normalize-space()='My Account']")
    private WebElement myAccountOption;

    @FindBy(xpath = "//button[@id='profile']")
    private WebElement myAccountHeader;

    @FindBy(xpath = "//button[@type='button'][normalize-space()='Logout']")
    private WebElement logoutOption;

    @FindBy(xpath = "//button[normalize-space()='Log In']")
    private WebElement loginButton;

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }


    public void clickProfileDropdown() {
        getWait5().until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
    }

    public void clickMyAccount() {
        getWait5().until(ExpectedConditions.elementToBeClickable(myAccountOption)).click();
    }

    public boolean isMyAccountPageDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(myAccountHeader)).isDisplayed();
    }

    // Click Profile Dropdown
    public void openProfileDropdown() {
        getWait5().until(ExpectedConditions.elementToBeClickable(profileDropdown)).click();
    }

    // Click "Logout"
    public void selectLogout() {
        openProfileDropdown();
        getWait5().until(ExpectedConditions.elementToBeClickable(logoutOption)).click();
    }

    // Verify successful logout (Checking if login button appears)
    public boolean isLoggedOut() {
        return getWait5().until(ExpectedConditions.visibilityOf(loginButton)).isDisplayed();
    }

    public boolean isDashboardDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(profileHeader)).isDisplayed();
    }

    public boolean isUserNameDisplayed(String kristina_drobava) {
        return getWait5().until(ExpectedConditions.visibilityOf(petOwnerName)).isDisplayed();
    }

    public boolean isPetCountDisplayed(String s) {
        return getWait5().until(ExpectedConditions.visibilityOf(petCount)).isDisplayed();
    }

    public boolean isIncompleteProfileWarningDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(incompleteProfileWarning)).isDisplayed();
    }

    public boolean isPetProfileDisplayed(String victor) {
        return getWait5().until(ExpectedConditions.visibilityOf(petProfileVictor)).isDisplayed();
    }

    public boolean isPendingChangesDisplayed() {
        return getWait5().until(ExpectedConditions.visibilityOf(pendingChanges)).isDisplayed();
    }

    public void clickPetProfile() {
        getWait5().until(ExpectedConditions.elementToBeClickable(petProfileVictor)).click();
    }


}


