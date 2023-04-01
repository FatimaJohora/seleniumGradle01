package seleniumAssignment4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BrowserNavigationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //Navigate Convenient way
        driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));

        //Navigate Longer way
        driver.navigate().to("https://www.amazon.com/");

        //Back
        driver.navigate().back();
        Thread.sleep(2000);

        //Forward
        driver.navigate().forward();
        Thread.sleep(2000);

        //Refresh
        driver.navigate().refresh();
        Thread.sleep(2000);

        driver.quit();

    }
}
