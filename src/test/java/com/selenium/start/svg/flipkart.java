package com.selenium.start.svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;

public class flipkart {
    @Test
    public void searchProduct(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("OnePlus Mobile");
        WebElement search= driver.findElement(By.xpath("//*[name()=\'svg\']/*[name()=\'title\']/following-sibling::*[name()=\'path\'][1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(search).click().perform();
        driver.switchTo().defaultContent();

    }
}
