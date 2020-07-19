package scenarios;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ChallengingDom extends BasePage {

    @Test
    public void testDynamicElement() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        //click on blue button

        //dd925dc0-a130-0138-b4d2-22ce01eb53a8
        //aa5826b0-a131-0138-b68a-22ce01eb53a8
        WebElement blueButton = driver.findElement(By.xpath("//a[@class='button']"));
        WebElement redButton = driver.findElement(By.xpath("//a[@class='button alert']"));
        WebElement greenButton = driver.findElement(By.xpath("//a[@class='button alert']"));
        blueButton.click();
    }

    @Test
    public void testTableCells() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");

        //Get text of each cell (except for headers)
        List<WebElement> cells = driver.findElements(By.xpath("//table//tbody//tr//td"));
        for(WebElement cell : cells) {
            System.out.println(cell.getText());
        }
    }

    @Test
    public void testHeaders() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        //Get text of each header
        List<WebElement> headers = driver.findElements(By.xpath("//table//th"));
        for(WebElement header : headers) {
            System.out.println(header.getText());
        }
    }


    @Test
    public void testEditDelete() {
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        //Get text of each header
        List<WebElement> editDeletes = driver.findElements(By.xpath("//table//td//a"));
        for(WebElement editDelete : editDeletes) {
            System.out.println(editDelete.getText());
        }
    }

}