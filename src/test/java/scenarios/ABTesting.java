package scenarios;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ABTesting extends BasePage {


    // TODO add java doc
    @Test
    public void testPageTitle() {
        driver.get("http://the-internet.herokuapp.com/");
        WebElement abTesting = driver.findElement(By.xpath("//a[.='A/B Testing']"));
        abTesting.click();
        WebElement header = driver.findElement(By.tagName("h3"));
        String actualHeader = header.getText();
        String expectedHeader = "A/B Test Control"; // A/B Test Variation 1
        //Assert.assertEquals(actualHeader, expectedHeader, "Header value is not right!");

        Assert.assertTrue(actualHeader.contains("A/B Test"));
        Assert.assertTrue(actualHeader.startsWith("A/B Test"));


        //TODO: Above use hamcrest assertion as header value is dynamic
        assertThat(actualHeader, containsString("A/B Test"));
        assertThat(actualHeader, startsWith("A/B Test"));
        //assertThat(actualHeader, endsWith("A/B Test"));
        //assertThat(actualHeader, is("A/B Test"));



    }
}
