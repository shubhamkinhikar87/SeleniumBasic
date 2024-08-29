package com.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitPractice {

    private WebDriver driver;
    @BeforeTest
    public void initilizeTest(){
        driver = new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
    }
    @Test
    public void NegativeTest(){
        driver.findElement(By.cssSelector("#login-username")).sendKeys("skinhikar@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("TWst@123");
        driver.findElement(By.id("js-login-btn")).click();
        //Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")),"Your email, password"));

        String warning = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")).getText();
        System.out.println(warning);
        Assert.assertEquals(warning,"Your email, password, IP address or location did not match");
    }
    @Test
    public void positiveTest(){
        driver.findElement(By.cssSelector("#login-username")).clear();
        driver.findElement(By.cssSelector("#login-username")).sendKeys("skinhikar@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Test@123");
        driver.findElement(By.id("js-login-btn")).click();
        //implicite wait
        //noinspection deprecation
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String  name = driver.findElement(By.cssSelector("span[data-qa='lufexuloga']")).getText();
        System.out.println(name);
        Assert.assertEquals(name,"Shubham Test");
    }
}
