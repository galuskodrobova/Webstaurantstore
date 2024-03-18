package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import java.util.List;

public class SearchResultsPage extends BasePage{


    @FindBy(xpath = "//a[text()='View Cart']")
    private WebElement viewCartButton;

    @FindBy(id = "searchval")
    private WebElement searchInput;

    @FindBy(css = "button[value='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//button[text()='Empty Cart']")
    private WebElement emptyCartButton;

    @FindBy(xpath = "//button[text()='Empty']")
    private WebElement emptyConfirmationButton;

    @FindBy(xpath = "//div[@id='product_listing']//span[contains(text(),'Table')]")
    private List<WebElement> productsSearchResult; //*[@data-testid='itemDescription']

    @FindBy(xpath = "//a[contains(@aria-label, 'current page, page ')]")
    private WebElement paging;

    @FindBy(xpath = "//input[@name='addToCartButton']")
    private List<WebElement> addToCartButton;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage inputSearchProduct(String text) {
        searchInput.sendKeys(text);

        return this;
    }

    public SearchResultsPage submitSearchButton() {
        searchButton.click();

        return this;
    }

    public SearchResultsPage emptyCartButton() {
        getWait5().until(ExpectedConditions.visibilityOf(emptyCartButton)).click();

        return this;
    }

    public CartPage emptyConfirmationButton() {
        wait.until(ExpectedConditions.visibilityOf(emptyConfirmationButton)).click();

        return new CartPage(getDriver());
    }

    public SearchResultsPage checkSearchResults() {
        do {
            // Check products on the current page
            for (WebElement product : productsSearchResult) {
                String title = product.getText();
                Assert.assertTrue(title.contains("Table"), "Product title does not contain 'Table'");
            }
            // Navigate to the next page if available
            navigateToNextPage(getDriver());
        } while (isNextPageAvailable(getDriver()));

        return this;
    }

    public void navigateToNextPage(WebDriver driver){
        getWait5().until(ExpectedConditions.visibilityOf(paging));
        // Get current page number
        int currentPage = Integer.parseInt(paging.getText());
        WebElement nextPageLink = driver
                .findElement(By.xpath("//a[contains(@aria-label, 'page " + (currentPage + 1) + "')]"));
        nextPageLink.click();
    }


    private boolean isNextPageAvailable(WebDriver driver) {
        getWait5().until(ExpectedConditions.visibilityOf(paging));
        int currentPage = Integer.parseInt(paging.getText());
        // Check if the next page link exists
        try {
            WebElement nextPageLink = driver
                    .findElement(By.xpath("//a[contains(@aria-label, 'page " + (currentPage + 1) + "')]"));

            return nextPageLink.isEnabled();

        } catch (NoSuchElementException e) {

            return false;
        }
    }

    public SearchResultsPage addLastProductToCart() {
        getWait5().until(ExpectedConditions.visibilityOfAllElements(addToCartButton));
        WebElement lastProduct = addToCartButton.get(addToCartButton.size() - 1);
        lastProduct.click();
        getWait5().until(ExpectedConditions.visibilityOf((viewCartButton)));
        viewCartButton.click();

        return this;
    }

}
