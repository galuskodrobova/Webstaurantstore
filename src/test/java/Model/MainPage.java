package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[text()='About Us']")
    private WebElement aboutUsLink;

    @FindBy(linkText = "Customers")
    private WebElement customersLink;

    @FindBy(linkText = "Community")
    private WebElement communityLink;

    @FindBy(linkText = "Sustainability")
    private WebElement sustainabilityLink;

    @FindBy(linkText = "Careers")
    private WebElement careersLink;

    @FindBy(linkText = "Investor Relations")
    private WebElement investorRelationsLink;

    @FindBy(linkText = "Newsroom")
    private WebElement newsroomLink;

    @FindBy(linkText = "Contact")
    private WebElement contactLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public AboutUsPage navigateToAboutUs() {
        getWait5().until(ExpectedConditions.elementToBeClickable(aboutUsLink)).click();
        return new AboutUsPage(getDriver());
    }

    public CustomersPage navigateToCustomers() {
        getWait5().until(ExpectedConditions.elementToBeClickable(customersLink)).click();
        return new CustomersPage(getDriver());
    }

    public CommunityPage navigateToCommunity() {
        getWait5().until(ExpectedConditions.elementToBeClickable(communityLink)).click();
        return new CommunityPage(getDriver());
    }

    public SustainabilityPage navigateToSustainability() {
        getWait5().until(ExpectedConditions.elementToBeClickable(sustainabilityLink)).click();
        return new SustainabilityPage(getDriver());
    }

    public CareersPage navigateToCareers() {
        getWait5().until(ExpectedConditions.elementToBeClickable(careersLink)).click();
        return new CareersPage(getDriver());
    }

    public InvestorRelationsPage navigateToInvestorRelations() {
        getWait5().until(ExpectedConditions.elementToBeClickable(investorRelationsLink)).click();
        return new InvestorRelationsPage(getDriver());
    }

    public NewsroomPage navigateToNewsroom() {
        getWait5().until(ExpectedConditions.elementToBeClickable(newsroomLink)).click();
        return new NewsroomPage(getDriver());
    }

    public ContactPage navigateToContact() {
        getWait5().until(ExpectedConditions.elementToBeClickable(contactLink)).click();
        return new ContactPage(getDriver());
    }
}
