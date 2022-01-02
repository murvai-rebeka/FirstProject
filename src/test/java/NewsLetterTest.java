import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewsLetterTest {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void subscribe() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.id("newsletter")).sendKeys("murvai01@mailinator.com");
        driver.findElement(By.cssSelector(".actions button[type=submit]")).click();
        WebElement webElement = driver.findElement(By.cssSelector(".success-msg span"));
        String actual = webElement.getText();
        Assert.assertEquals("Thank you for your subscription.", actual);
    }

    @Test
    public void unSubscribe() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.id("newsletter")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.cssSelector(".actions button[type=submit]")).click();
        driver.get("http://testfasttrackit.info/selenium-test/newsletter/manage/");
        driver.findElement(By.id("subscription")).click();
        driver.findElement(By.cssSelector(".buttons-set button[type=submit]")).click();
        WebElement webElement = driver.findElement(By.cssSelector(".success-msg span"));
        String actual = webElement.getText();
        Assert.assertEquals("The subscription has been removed.", actual);
    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}
