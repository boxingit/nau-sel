package foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

/**
 * In this class I will demo how to execute/run Selenium test
 * without using WebDriverManager and using java main method.
 * @author Rasul Yumukhov
 */
public class FirstTest {

    public static void main(String[] args) {

        //Tells the system where the chromedriver executable is located
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");

        //For windows give the path as follows and comment out above line.
        //System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");

        //Create a WebDriver object
        WebDriver driver = new ChromeDriver();

        //Open the website / go to the URL given
        driver.get("https://the-internet.herokuapp.com/");


        /*
        driver.get() is used to navigate particular URL(website) and wait till page load.
        driver.navigate().to() is used to navigate to particular URL and does not wait until the page load.

        It maintains browser history or cookies to navigate back or forward.
        */
//        driver.navigate().to("https://the-internet.herokuapp.com/");
//        driver.navigate().back();
//        driver.navigate().forward();


        //Verify tge page title is correct
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle, expectedTitle, "Hey Dad, my test failed. Because the page title is wrong!");

// Uncomment below lines to catch the exception so that program execution
// does not halt.

//        try {
//            Assert.assertEquals(actualTitle, expectedTitle, "Hey Dad, my test failed. Because the page title is wrong!");
//        } catch (AssertionError e) {
//            System.err.println("\nException handled");
//        }

        //At the end of the test kill the browser
        driver.quit();

    }
}