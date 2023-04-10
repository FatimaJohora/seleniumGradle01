package dev.testNGAssignment1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class ParaBankBase2 {

    protected static WebDriver driver;
    @BeforeMethod
    public void initBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/admin.htm");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
