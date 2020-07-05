package scenarios;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuth extends BasePage {

    @Test
    public void testBasicAuthorization() {
        //user name = admin psw = admin
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String expectedMsg = "Congratulations! You must have the proper credentials.";

        WebElement message = driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]"));
        String actualMsg = message.getText();

        Assert.assertEquals(actualMsg, expectedMsg, "Actual header did not match!");
    }
}
