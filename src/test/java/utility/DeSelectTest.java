package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DeSelectTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //Select & deselect  By visible Text
       // driver.findElement(By.cssSelector("[data-action-type='DISMISS']")).click();
        WebElement allDepartment = driver.findElement(By.cssSelector("#searchDropdownBox"));
        allDepartment.click();
        Select select = new Select(allDepartment);
        select.selectByVisibleText("Arts & Crafts");

        for(WebElement option :select.getOptions()){
            System.out.println(option.getText());
       }

       // select.deselectByVisibleText("Arts & Crafts");
        Thread.sleep(3000);
        select.selectByIndex(4);
        Thread.sleep(3000);
        for(WebElement option :select.getOptions()) {
            System.out.println(option.isSelected());
        }

        driver.quit();
    }
}
