import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.time.Duration;

public class FirefoxBrowserLaunch {
    @Test
     void browserLaunchTest() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        System.out.println("This is the current URL : " + driver.getCurrentUrl());
        System.out.println("The title of the current page is :" + driver.getTitle());

        driver.quit();
    }
}
