import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver driver;

    @Before
    public void openBrowser() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void loginWithValidCredentials() {

        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement welcomeElement = driver.findElement(By.cssSelector("p.hello strong"));
        String welcomeText = welcomeElement.getText();

        Assert.assertTrue(welcomeElement.isDisplayed());
        Assert.assertEquals("Hello, murvai murvai!", welcomeText);

    }

    @Test
    public void loginWithInvalidCredentials() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai1@mailinator.com.org");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement webElement = driver.findElement(By.cssSelector("ul.messages .error-msg span"));

        Assert.assertTrue(webElement.isDisplayed());
        Assert.assertEquals("Invalid login or password.", webElement.getText());

    }

    @Test
    public void logOutTest() {
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.id("email")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        WebElement webElement = driver.findElement(By.cssSelector(".page-title h1"));
        String actual = webElement.getText();
        Assert.assertEquals("YOU ARE NOW LOGGED OUT", actual);
    }
    @Test
    public void forgotPassword(){
        WebElement accountLink = driver.findElement(By.cssSelector(".skip-account"));
        accountLink.click();
        driver.findElement(By.cssSelector("#header-account li.last a")).click();
        driver.findElement(By.cssSelector(".f-left ")).click();
        driver.findElement(By.id("email_address")).sendKeys("murvai@mailinator.com");
        driver.findElement(By.cssSelector(".buttons-set button[type=submit]")).click();
        WebElement webElement = driver.findElement(By.cssSelector(".success-msg span"));
        String actual = webElement.getText();
        Assert.assertEquals("If there is an account associated with murvai@mailinator.com you will receive an email with a link to reset your password.", actual);

    }




    @After
    public void closeBrowser() {
        driver.close();
    }
}