package seleniumAssignment5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

public class CookieTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Add Cookie
        driver.manage().addCookie(new Cookie("myTest","Test56789"));

        //Get Named Cookie
        System.out.println(driver.manage().getCookieNamed("myTest"));

        //Delete Cookie
        driver.manage().deleteCookieNamed("myTest");

        //Get All Cookies
        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie cookie : cookies){
            System.out.println("Cookie name is : "+cookie.getName() + " .  Expiry time : "+ cookie.getExpiry());
        }

        System.out.println("Total number of cookie :" +driver.manage().getCookies().size());

       // Delete All Cookies
        driver.manage().deleteAllCookies();
        System.out.println("Total number of cookie :" +driver.manage().getCookies().size());

        // Close Browser
        driver.quit();

    }
}
