package scenarios;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ABTesting extends BasePage {


    @Test
    public void testPageTitle() {
        driver.get("http://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.xpath("//a[.='A/B Testing']"));
        abTesting.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        String actualHeader = header.getText();
        String expectedHeader = "A/B Test Control";
        Assert.assertEquals(actualHeader, expectedHeader, "Header value is not right!");

        //TODO: Above use hamcrest assertion as header value is dynamic

    }
}
