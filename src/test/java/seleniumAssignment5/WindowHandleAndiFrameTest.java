package seleniumAssignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class WindowHandleAndiFrameTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.paychex.com/login");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.findElement(By.xpath("//a[text()='Paychex Flex login']")).click();


        // switch to new window or tab
        Set<String> window = driver.getWindowHandles();
        Iterator<String>ite = window.iterator();

        String parentWindow = ite.next();
        String childWindow  = ite.next();

        driver.switchTo().window(childWindow);

        //Switch to frame
        driver.switchTo().frame("login");
        System.out.println(driver.findElement(By.linkText("Forgot Username or Password?")).getText());

        //switch to the original or parent window
        driver.switchTo().window(parentWindow);

        driver.quit();
    }
}
