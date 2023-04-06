package seleniumAssignment6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoblaze.com/index.html");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));

        //Click on login link
        WebElement loginLink = driver.findElement(By.id("login2"));
        loginLink.click();

        //fill up the login form & use Explicit wait
        WebElement usernameField = driver.findElement(By.id("loginusername"));
        wait.until(ExpectedConditions.elementToBeClickable(usernameField));
        usernameField.sendKeys("Safwan");

        WebElement passwordField = driver.findElement(By.id("loginpassword"));
        passwordField.sendKeys("1234567");

        WebElement loginButton = driver.findElement(By.cssSelector("[onclick='logIn()']"));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();

        //Alert handle & use Explicit wait
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // navigate another url & use Explicit wait
        driver.navigate().to("https://demoqa.com/modal-dialogs");

        driver.findElement(By.id("showSmallModal")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#example-modal-sizes-title-sm"))));
        WebElement text = driver.findElement(By.cssSelector(".modal-body"));
        System.out.println(text);

        WebElement closeButton = driver.findElement(By.id("closeSmallModal"));
        closeButton.click();

        driver.quit();

    }
}
