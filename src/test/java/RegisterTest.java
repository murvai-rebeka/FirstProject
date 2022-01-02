import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegisterTest {
    private WebDriver driver;
    @Before
    public void openBrowser(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void registertest(){

        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account > div > ul > li:nth-child(5) > a")).click();
        driver.findElement(By.id("firstname")).sendKeys("murvai");
        driver.findElement(By.id("lastname")).sendKeys("murvai");
        driver.findElement(By.id("email_address")).sendKeys("murvai_"+java.util.UUID.randomUUID()+"@mailinator.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.id("is_subscribed")).click();
        driver.findElement(By.cssSelector("#form-validate > div.buttons-set > button > span > span")).click();

        WebElement webElement = driver.findElement(By.cssSelector("body > div > div.page > div.main-container.col2-left-layout > div > div.col-main > div.my-account > div > ul > li > ul > li > span"));
        String succesText = webElement.getText();

        Assert.assertTrue(webElement.isDisplayed());
        Assert.assertEquals("Thank you for registering with Madison Island.", succesText );



    }
    @After
    public void closeBrowser(){
        driver.close();
    }
}
