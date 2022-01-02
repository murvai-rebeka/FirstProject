import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WishListTest {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void addToWishlistTest() {

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();


        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[5]/a")).click();
        // accountLink.click();
        driver.findElement(By.cssSelector("a.link-wishlist:first-of-type")).click();
        String succesText = driver.findElement(By.cssSelector(".success-msg span")).getText();
        Assert.assertTrue(succesText.contains("has been added to your wishlist"));

        accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        String wishtext = driver.findElement(By.cssSelector("#header-account li:nth-child(2) a")).getText();
        Assert.assertTrue(wishtext.contains("item"));

        String productname = driver.findElement(By.cssSelector(".product-name:first-of-type a")).getText();
        Assert.assertTrue(productname.contains("ELIZABETH"));

        String productprice = driver.findElement(By.cssSelector("#product-price-421 span")).getText();
        Assert.assertEquals("210,00 RON", productprice);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }

}
