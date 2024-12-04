import Base.BaseTest;
import Model.AboutUsPage;
import Model.EquipmentServicesPage;
import Model.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void testEquipmentServicesFormSubmission() {
        EquipmentServicesPage formSubmission = new EquipmentServicesPage(getDriver())
                .enterBusinessName("Kristina's Café")
                .enterPhoneNumber("704-123-4567")
                .enterEmail("kristina@example.com")
                .clickSendMessage();

        boolean isMessageDisplayed = formSubmission.isSuccessMessageDisplayed();

        Assert.assertTrue(isMessageDisplayed, "Success message was not displayed after form submission.");
    }

    @Test
    public void testNavigateToAboutUs() {
        AboutUsPage aboutUsPage = new MainPage(getDriver())
                .navigateToAboutUs();  // Assuming this method clicks the About Us link

        String pageTitle = aboutUsPage.getPageTitle();

        Assert.assertEquals(pageTitle, "About Us - Coca-Cola Consolidated", "About Us page title is incorrect");
    }




}
