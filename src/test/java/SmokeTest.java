import Base.BaseTest;
import Model.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class SmokeTest extends BaseTest {


    @Test(priority = 1)
    public void testNavigateToSignIn() {
        SignInPage signInPage = new MainPage(getDriver())
                .navigateToSignIn();  // Assuming this method clicks the Sign In link

        String pageTitle = signInPage.getPageTitle();

        Assert.assertEquals(pageTitle, "PetScreening", "PetScreening Login page title is incorrect");
    }


    @Test(priority = 2)
    public void testSuccessfulLogin() {
        testNavigateToSignIn();

        LoginPage loginPage = new LoginPage(getDriver())
                .enterEmail("galuskodrobova@gmail.com")
                .enterPassword("Qwerty123!")
                .clickLogin();

        assertTrue("Login failed but expected to succeed!", loginPage.isLoginSuccessful());

    }


    @Test(priority = 3)
    public void testInvalidLogin() {
        testNavigateToSignIn();
        LoginPage loginPage = new LoginPage(getDriver())
                .enterEmail("wronguser@example.com")
                .enterPassword("WrongPassword")
                .clickLogin();

        assertTrue("Login should have failed, but it passed!", loginPage.isLoginEmailFailed());
    }

    @Test
    public void testSuccessfulLoginAndDashboardElements() {
        testSuccessfulLogin();
        // Navigate to Dashboard and verify elements
        DashboardPage dashboardPage = new DashboardPage(getDriver());

        assertTrue("Dashboard is not displayed!", dashboardPage.isDashboardDisplayed());
        assertTrue("User name is incorrect!", dashboardPage.isUserNameDisplayed("Kristina Drobava"));
        assertTrue("Pet count is incorrect!", dashboardPage.isPetCountDisplayed("1 pet"));
        assertTrue("Incomplete profile warning is missing!", dashboardPage.isIncompleteProfileWarningDisplayed());
        assertTrue("Victor's pet profile is missing!", dashboardPage.isPetProfileDisplayed("Victor"));
        assertTrue("Pending changes status is missing!", dashboardPage.isPendingChangesDisplayed());
    }

    @Test
    public void testOpenMyAccountFromProfileDropdown() {
        // Step 1: Log in
       testSuccessfulLogin();

        // Verify login success
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed!");

        // Step 2: Click on Profile dropdown
        dashboardPage.clickProfileDropdown();

        // Step 3: Click on "My Account"
        dashboardPage.clickMyAccount();

        // Step 4: Verify that "My Account" page is opened
        Assert.assertTrue(dashboardPage.isMyAccountPageDisplayed(), "My Account page did not open!");
    }

    @Test
    public void testLogoutFromProfileDropdown() {
        testSuccessfulLogin();

        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed!");

        // Click on "Logout" from the dropdown
        dashboardPage.selectLogout();
        Assert.assertTrue(dashboardPage.isLoggedOut(), "Logout failed!");
    }

    @Test
    public void testMyAccountDetailsDisplayed() {
        testOpenMyAccountFromProfileDropdown();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(), "My Account page is not displayed!");

        Assert.assertEquals(myAccountPage.getFirstName(), "Kristina", "First name is incorrect!");
        Assert.assertEquals(myAccountPage.getLastName(), "Drobava", "Last name is incorrect!");
        Assert.assertEquals(myAccountPage.getEmail(), "galuskodrobova@gmail.com", "Email is incorrect!");
    }

    @Test
    public void testInvalidMyAccountDetails() {
        testOpenMyAccountFromProfileDropdown();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        Assert.assertTrue(myAccountPage.isMyAccountPageDisplayed(), "My Account page is not displayed!");

        Assert.assertNotEquals(myAccountPage.getFirstName(), "WrongName", "First name should not match!");
        Assert.assertNotEquals(myAccountPage.getLastName(), "WrongLastName", "Last name should not match!");
        Assert.assertNotEquals(myAccountPage.getEmail(), "wrongemail@example.com", "Email should not match!");
    }



}
