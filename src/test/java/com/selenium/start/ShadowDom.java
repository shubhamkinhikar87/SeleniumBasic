package com.selenium.start;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShadowDom {

    @Test
    public void testShadowDom(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement username = (WebElement)js.executeScript("return document.querySelector('div.jackPart').shadowRoot.querySelector('#kils')");
        username.sendKeys("ShubhamK");
    }
}
