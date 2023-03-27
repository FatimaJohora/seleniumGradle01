package seleniumAssignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.time.Duration;
/*
1. Dynamic Locator use CSS selector
  a) * contains
  b) ^ start with
  c) $ end with
  2.Interacting with web elements
 */

public class WebElements {
    @Test
    void dynamicWebElementsTest() throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        boolean verifyLogo = driver.findElement(By.cssSelector("[alt$='-branding']")).isDisplayed();
        System.out.println("Company logo is displayed :" + verifyLogo);

        WebElement username = driver.findElement(By.cssSelector("[name='username']"));
        username.clear();
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.cssSelector("input[name^='pass']"));
        password.clear();
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.cssSelector("form.oxd-form"));
        loginButton.submit();

        driver.quit();


    }
}
