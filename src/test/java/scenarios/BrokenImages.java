package scenarios;

import base.BasePage;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenImages extends BasePage {

    @Test
    public void testBrokenImages() {
        driver.get("http://the-internet.herokuapp.com/broken_images");
        List<WebElement> allImages = driver.findElements(By.tagName("img"));

        for (WebElement img : allImages) {
            //isImageBroken(img);
            //System.out.println(img.getAttribute("outerHTML") + " is broken " +isImageBroken2(img));
            isImageBroken3(img);
        }

    }

    public void isImageBroken(WebElement image) {
        if (image.getAttribute("naturalWidth").equals("0")) {
            System.err.println(image.getAttribute("outerHTML") + "image is broken"); //<img src="asdf.jpg">image is broken

        }
    }


    public boolean isImageBroken2(WebElement image) {
        boolean isBroken = image.getAttribute("naturalWidth").equals("0");
        return isBroken;
    }

    public void isImageBroken3(WebElement img) {
        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(img.getAttribute("src"));
            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() != 200) {
                System.err.println(img.getAttribute("outerHTML") + " is broken");
            }

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

}


// <img src="asdf.jpg">