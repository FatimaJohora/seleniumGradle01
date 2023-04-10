package dev.testNGAssignment1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParaBankTest2 extends ParaBankBase2 {

    @Test
    public void verifyTitleShouldSucceed(){
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle().trim(),"ParaBank | Administration");
    }

    @Test
    public void verifyParaBankLogoIsDisplay(){
        boolean verifyLogo = driver.findElement(By.cssSelector("[title='ParaBank']")).isDisplayed();
        Assert.assertTrue(verifyLogo);
    }
    @Test
    public void verifyLoginPageShouldSucceed(){
        String loginPage = driver.findElement(By.cssSelector("#leftPanel h2")).getText();
        Assert.assertEquals(loginPage,"Customer Login");
    }
    @Test
    public void verifyLoginShouldSucceed() {
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.clear();
        usernameField.sendKeys("del");

        WebElement passwordField = driver.findElement(By.cssSelector("[name='password']"));
        passwordField.clear();
        passwordField.sendKeys("del");

        WebElement loginBtn = driver.findElement(By.cssSelector("[value='Log In']"));
        loginBtn.click();
        WebElement logoutLink = driver.findElement(By.linkText("Log Out"));
        String logout = logoutLink.getText();
        Assert.assertEquals(logout, "Log Out");
        logoutLink.click();


    }

    }