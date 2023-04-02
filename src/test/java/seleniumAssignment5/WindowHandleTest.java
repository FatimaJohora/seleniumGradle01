package seleniumAssignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class WindowHandleTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        String originalWindow = driver.getWindowHandle();

       // open a new tab and switch to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2000);
        driver.switchTo().window(originalWindow);

        // Open a new window and switch to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://demoqa.com/sample");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());
        Thread.sleep(2000);
        Set<String> windows = driver.getWindowHandles();
        System.out.println(windows.size());

        //Close the tab or window
        driver.close();

        //Switch back to the original window
        driver.switchTo().window(originalWindow);

        driver.quit();










    }
}
