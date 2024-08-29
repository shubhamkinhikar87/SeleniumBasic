package com.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.time.Duration;

public class  Selenium01 {
    @Test
    public void positiveScenario(){

        WebDriver driver= new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("#login-username")).sendKeys("skinhikar@gmail.com");
        driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("TWst@123");
        driver.findElement(By.id("js-login-btn")).click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='js-notification-box-msg']")));
        String warning = driver.findElement(By.xpath("//div[@id='js-notification-box-msg']")).getText();
        System.out.println(warning);
        Assert.assertEquals(warning,"Your email, password, IP address or location did not match");
        driver.quit();

    }
}
