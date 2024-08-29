package com.selenium.start;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DropdownAlert {
    private WebDriver driver;
    @BeforeTest
    public void initilizeTest(){
        driver = new ChromeDriver();

    }
    @Test
    public void dropdownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        select.selectByVisibleText("Option 1");
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        select.selectByVisibleText("Option 2");

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        System.out.println(alert.getText());
        alert.sendKeys("Shubham");
        alert.accept();



    }




}
