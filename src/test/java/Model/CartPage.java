package Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CartPage extends BasePage{


    @FindBy(xpath = "//div[@class='cartItem ag-item gtm-product-auto ']")
    private List<WebElement> cartItems;

    @FindBy(xpath = "//div[@class='empty-cart__text']//p")
    private WebElement emptyCartMessage;


    public CartPage(WebDriver driver) {
        super(driver);
    }


    public String getEmptyCartMessage() {

        return emptyCartMessage.getText();
    }
}
