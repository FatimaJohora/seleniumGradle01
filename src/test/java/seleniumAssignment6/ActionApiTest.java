package seleniumAssignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ActionApiTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.dell.com/en-uk/shop/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.id("ooc-destination-country")).click();

        //Create action class & move to element
        Actions action = new Actions(driver);
        WebElement accessories = driver.findElement(By.xpath("//*[@id=\"unified-masthead-navigation\"]/nav/ul/li[3]/button/span"));
        action.moveToElement(accessories).perform();
        Thread.sleep(2000);

        WebElement laptops = driver.findElement(By.xpath("//button[text()='Laptops']"));
        action.moveToElement(laptops).perform();
        Thread.sleep(2000);

        WebElement viewAllLaptops = driver.findElement(By.linkText("View All Laptops"));
        action.moveToElement(viewAllLaptops).perform();
        Thread.sleep(2000);

        //Click and release
        action.click(viewAllLaptops).perform();
        Thread.sleep(2000);

        //Click and hold
        action.clickAndHold(driver.findElement(By.cssSelector(".mh-icon"))).perform();
        Thread.sleep(2000);

        //navigate to another website
        driver.navigate().to("https://demoqa.com/droppable#");

        // dragAndDrop
        WebElement draggable = driver.findElement(By.cssSelector("#draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        action.dragAndDrop(draggable,droppable).perform();
        Thread.sleep(2000);

        //Double click
        action.doubleClick(driver.findElement(By.cssSelector("#droppableExample-tab-accept"))).perform();
        Thread.sleep(2000);

        //Context Click Or right click.
        action.contextClick(driver.findElement(By.linkText("Prevent Propogation"))).perform();
        Thread.sleep(2000);

        driver.quit();
    }
}
