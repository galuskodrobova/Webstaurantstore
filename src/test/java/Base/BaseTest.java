package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    protected void loginWeb() {
        driver.get("https://www.webstaurantstore.com/");
    }

    @BeforeClass
    protected void before() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    protected void beforeTest() {
        driver = new ChromeDriver();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginWeb();
        getDriver().manage().window().maximize();
    }

    @AfterMethod
    protected  void afterTest() {
        getDriver().quit();
    }
}

