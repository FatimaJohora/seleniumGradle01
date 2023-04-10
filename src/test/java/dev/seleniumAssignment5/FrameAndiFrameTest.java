package dev.seleniumAssignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class FrameAndiFrameTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/frames");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebElement defaultWindow = driver.findElement(By.id("framesWrapper"));
        System.out.println(defaultWindow.getText());

        //Switch to the frame
        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        //Switch to the defaultContent
        driver.switchTo().defaultContent();

        // Switches to the second frame
        driver.switchTo().frame("frame2");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        //Switch to the defaultContent
        driver.switchTo().defaultContent();
        System.out.println(defaultWindow.getText());

        driver.quit();

    }
}
