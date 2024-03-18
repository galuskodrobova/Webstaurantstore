import Base.BaseTest;
import Model.CartPage;
import Model.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmokeTest extends BaseTest {


    @Test
    public void testSearchShoppingCartValidation() {

        CartPage submitSearch = new SearchResultsPage(getDriver())
                .inputSearchProduct("stainless work table")
                .submitSearchButton()
                .checkSearchResults()
                .addLastProductToCart()
                .emptyCartButton()
                .emptyConfirmationButton();

        String actualMessage = submitSearch.getEmptyCartMessage();
        String expectedMessage = "Your cart is empty.";

        Assert.assertEquals(actualMessage, expectedMessage, "Empty cart message does not match expected");

    }
}


