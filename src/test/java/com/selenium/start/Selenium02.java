package com.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Selenium02 {
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String  name = driver.findElement(By.cssSelector("span[data-qa='lufexuloga']")).getText();
        System.out.println(name);
        Assert.assertEquals(name,"Shubham Test");
    }


}
