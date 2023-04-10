package dev.seleniumAssignment3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Information {
    @Test
    void informationAboutWebElement() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.southwest.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

      //Is Displayed
        boolean  verifyLogo = driver.findElement(By.cssSelector("a[class$='header--logo']")).isDisplayed();
        Assert.assertTrue(verifyLogo);

        WebElement oneWay = driver.findElement(By.cssSelector("[value='oneway']"));
        oneWay.click();

        //IsSelected
        boolean verifyDollar = driver.findElement(By.cssSelector("input[value='USD']")).isSelected();
        System.out.println("Dollar radio button is selected :"+verifyDollar);

        //Size and Position: get Rect()

        WebElement departField = driver.findElement(By.cssSelector("#LandingAirBookingSearchForm_originationAirportCode"));
        departField.clear();
        departField.sendKeys("Dallas");
        System.out.println("Height = "+departField.getRect().height +" & " + "width = "+ departField.getRect().width);

        //Tag Name & Get CSS Value:
        WebElement arriveField = driver.findElement(By.cssSelector("#LandingAirBookingSearchForm_destinationAirportCode"));
        arriveField.clear();
        arriveField.sendKeys("LGA");
        System.out.println("Front size of arrive field is = " + arriveField.getCssValue("font").trim());
        System.out.println("Tag name of arriveField WebElement is :" +arriveField.getTagName());

        //Is Enabled
        boolean verifyReturnDate =  driver.findElement(By.cssSelector("#LandingAirBookingSearchForm_returnDate")).isEnabled();
        System.out.println("Return date is enable :" +verifyReturnDate);

        //Text Content
        System.out.println(driver.findElement(By.id("text_block_rgw0w76fles")).getText());

        // Attributes
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        for(WebElement webElement : allLinks){
            String links = webElement.getAttribute("href").trim();
            if (links!=null && !links.isEmpty()){
                System.out.println(links);
            }
        }
        System.out.println(allLinks.size());


        driver.quit();

    }
}
