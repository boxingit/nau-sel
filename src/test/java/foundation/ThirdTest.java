package foundation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //tell ur computer to set the chromedriver
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        //create a driver object
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        //end the session
        driver.quit();
    }

    @Test
    public void testCurrentUrl() {
        //open the app
        driver.get("http://the-internet.herokuapp.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "http://the-internet.herokuapp.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "Boss, the URLs are not matchimg!");
    }
}
