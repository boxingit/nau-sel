package scenarios;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class AddRemoveElements extends BasePage {

    @Test
    public void testAddElements() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button"));
        addElementButton.click();
        addElementButton.click();
        addElementButton.click();

        List<WebElement> deleteButtons = driver.findElements(By.xpath("//div[@id='elements']//button"));
        Assert.assertEquals(deleteButtons.size(), 3);

    }

    @Test
    public void testDeleteButtonIsDisplayed() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button"));
        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']//button"));
        Assert.assertTrue(deleteButton.isDisplayed());

    }

    @Test
    public void testDeleteButtonIsNotDisplayed() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addElementButton = driver.findElement(By.xpath("//button"));
        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//div[@id='elements']//button"));
        deleteButton.click();

        /*
        * If you try to use isDisplayed() method to verify that the element is not displayed
        * on the page using below assertions then you will get this error:
        *
        *  org.openqa.selenium.StaleElementReferenceException:
        *  stale element reference: element is not attached to the page document
        *  //Assert.assertTrue(! deleteButton.isDisplayed());
        *  //Assert.assertFalse(deleteButton.isDisplayed());
         * */

        //this is how we should handle the scenario when element is not
        //going to be displayed on thew page

        Assert.assertFalse(isElementDisplayed(By.xpath("//div[@id='elements']//button")));

        //Assert.assertFalse(isElementDisplayed2(By.xpath("//div[@id='elements']//button")));

    }

    public boolean isElementDisplayed(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            System.err.println("Delete button is not displayed!"); //print msg in red
            return false;
        }
    }

    /**
     * Alternatively you can use this method
     * @param locator = By locator
     * @return true / false
     */
    public boolean isElementDisplayed2(By locator) {
        int count = driver.findElements(locator).size(); //this will return count of element
        return count > 0; //if count > 0 then this will return true, else it will return false
    }


}
