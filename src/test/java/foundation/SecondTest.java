package foundation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * In this class I will navigate to a URL using TestNG annotations
 * and using WebDriver Manager.
 */
public class SecondTest {

    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPageTitle() {
        driver.get("https://the-internet.herokuapp.com/");
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        Assert.assertEquals(actualTitle, expectedTitle,
                "Sorry mom, I could not verify the page title :(");
    }

    //More detailed explanation about driver.navigate().to() method


    @Test
    public void testNavigateToMethod() {
        driver.get("https://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.xpath("//a[.='A/B Testing']"));
        abTesting.click();

        driver.navigate().back();

        driver.navigate().forward();

    }
}
