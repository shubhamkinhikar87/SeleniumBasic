package com.selenium.start.svg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class map {
@Test
public void navigateToState(){
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.amcharts.com/svg-maps/?map=india");
    driver.manage().window().maximize();
    List<WebElement> states= driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
    for(WebElement s: states){
        System.out.println(s.getAttribute("aria-label"));
        if(s.getAttribute("aria-label").trim().equals("Tripura")){
            new Actions(driver).moveToElement(s).click().perform();
        }
    }
}
}

