package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CartPage extends BasePage{


    @FindBy(xpath = "//div[@class='cartItem ag-item gtm-product-auto ']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='empty-cart__text']//p[1]")
    private WebElement emptyCartMessage;


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public String getEmptyCartMessage() {
        getWait5().until(ExpectedConditions.visibilityOf((emptyCartMessage)));

        return emptyCartMessage.getText();
    }
}
