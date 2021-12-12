import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String args[]) {
       /* System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aboutyou.com");

        WebElement outfitLink = driver.findElement(By.cssSelector("#react-root > div.sc-12pn4qb-0.hGfiVS > header > div > div.row.navigation > ul > li:nth-child(1) > a"));
        outfitLink.click();

        driver.close();*/
        /*WishListTest wishListTest = new WishListTest();
        wishListTest.addToWishlistTest();

        RegisterTest registerTest = new RegisterTest();
        registerTest.registertest();  */

        LoginTest login = new LoginTest();
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Starting tests...");
       // login.loginWithValidCredentials();
        login.loginWithInvalidCredentials();

    }
}
