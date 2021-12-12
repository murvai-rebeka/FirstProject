import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WishListTest {
    public void addToWishlistTest()  {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li.last > a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();


        driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[5]/a")).click();
       // accountLink.click();
        driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li > div > div.actions > ul > li:nth-child(1) > a")).click();
        String succesText = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div.my-wishlist > ul > li > ul > li > span")).getText();
        if (succesText.contains("has been added to your wishlist"))
            System.out.println("Success");
        else
            System.err.println("Fail");

        accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        String wishtext = driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(2) > a")).getText();
        if (wishtext.contains("item"))
            System.out.println("Success");
        else
            System.err.println("Fail");

       String productname = driver.findElement(By.cssSelector("#item_931 > td.wishlist-cell1.customer-wishlist-item-info > h3 > a")).getText();
       if (productname.contains("ELIZABETH"))
           System.out.println("Success");
       else
           System.err.println("Fail");

       String productprice = driver.findElement(By.cssSelector("#product-price-421 > span")).getText();
       if (productprice.equals("210,00 RON"))
       System.out.println("Succes");
       else
           System.out.println("Fail");
        driver.close();
    }

}
