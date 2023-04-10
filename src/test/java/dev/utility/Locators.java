package dev.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Locators {
    @Test
    void paraBankLocatorTest()  {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement fullName = driver.findElement(By.id("userName"));
        fullName.sendKeys("Safwan");

        driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");

        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Safwan19");

        boolean verifySolutions = driver.findElement(By.tagName("li")).isDisplayed();
        Assert.assertTrue(verifySolutions);

        boolean verifyATM = driver.findElement(By.className("captionone")).isDisplayed();
        Assert.assertTrue(verifyATM);

        WebElement aboutUs = driver.findElement(By.linkText("About Us"));
        aboutUs.click();

        WebElement adminPageLink = driver.findElement(By.partialLinkText("min Pa"));
        adminPageLink.click();

        WebElement passwordField = driver.findElement(By.cssSelector("[name='password']"));
        passwordField.sendKeys("56789");

        WebElement loginButton = driver.findElement(By.cssSelector(".login .button"));
        loginButton.click();

        driver.quit();
    }
}
