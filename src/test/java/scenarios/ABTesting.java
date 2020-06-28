package scenarios;

import foundation.BasePage;
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

        WebElement header = driver.findElement(By.xpath("//h3[.='A/B Test Control']"));

        String actualHeader = header.getText();
        String expectedHeader = "A/B Test Control";

        Assert.assertEquals(actualHeader, expectedHeader, "Header value is not right!");

    }
}
