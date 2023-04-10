package dev.seleniumAssignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SelectClassTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/newtours/register.php");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        WebElement country = driver.findElement(By.cssSelector("select[name='country']"));
        country.click();
        //By visible Text
        Select select = new Select(country);
        select.selectByVisibleText("ALBANIA");
        Thread.sleep(2000);

        // Select By Value
        select.selectByValue("ANTARCTICA");
        Thread.sleep(2000);

        //Select By Index
        select.selectByIndex(8);
        Thread.sleep(2000);

        //Select option
        for(WebElement option :select.getOptions()){
            System.out.println(option.getText());
        }
       driver.quit();
    }
}
