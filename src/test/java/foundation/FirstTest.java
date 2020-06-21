package foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * In this class I will demo how to execute/run Selenium test
 * without using WebDriverManager and using java main method.
 * @author Rasul Yumukhov
 */
public class FirstTest {

    public static void main(String[] args) {

        //Tells the system where the chromedriver executable is located
        System.setProperty("webdriver.chrome.driver", "resources/mac/chromedriver");

        //For windows give the path as follows
        //System.setProperty("webdriver.chrome.driver", "resources/windows/chromedriver.exe");

        //Create a WebDriver object
        WebDriver driver = new ChromeDriver();

        //Open the website / go to the URL given
        driver.get("https://the-internet.herokuapp.com/");

        //At the end of the test kill the browser
        driver.quit();

    }
}
