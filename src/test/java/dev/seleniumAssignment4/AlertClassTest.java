package dev.seleniumAssignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class AlertClassTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        // scroll Down
        JavascriptExecutor Scroll = (JavascriptExecutor)driver;
        Scroll.executeScript("scroll(0,300)");

        //Alerts
        driver.findElement(By.cssSelector("a[onclick*='alert']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        //Confirm
        Scroll.executeScript("scroll(0,900)");
        driver.findElement(By.cssSelector("a[onclick*='confirm']")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println(confirmAlert.getText());
        confirmAlert.dismiss();
        Thread.sleep(2000);

        //Prompt
        Scroll.executeScript("scroll(0,600)");
        driver.findElement(By.cssSelector("a[onclick*='prompt']")).click();
        Alert promptAlert = driver.switchTo().alert();
        Thread.sleep(2000);
        promptAlert.sendKeys("Selenium");
        promptAlert.accept();
        Thread.sleep(2000);

        driver.quit();




    }
}
