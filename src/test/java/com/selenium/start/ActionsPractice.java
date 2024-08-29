package com.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActionsPractice {
    private WebDriver driver;
    @BeforeTest
    public void initilizeTest(){
        driver = new ChromeDriver();

    }
    @Test
    public void TestActions(){
    driver.get("https://www.makemytrip.com/");
    driver.manage().window().maximize();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-cy='closeModal']")));

    driver.findElement(By.xpath("//span[@data-cy='closeModal']")).click();
    Actions actions= new Actions(driver);
    WebElement from  = driver.findElement(By.cssSelector("#fromCity"));
    actions.moveToElement(from).click().sendKeys("Mumbai").perform();

    List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']/li"));

    for(WebElement wb: list){

        if (wb.getText().contains("Mumbai")){
            wb.click();
            break;
        }
    }

    }
    @Test
    public void TestAction2(){
        driver.get("https://awesomeqa.com/practice.html");
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(driver.findElement(By.cssSelector("input[name='firstname']")),"Shubham Kinhikar").keyUp(Keys.SHIFT).perform();


    }



}
