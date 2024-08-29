package com.selenium.start;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExceptionHandling {
    private WebDriver driver;
    @BeforeTest
    public void initilizeTest(){
        driver = new ChromeDriver();

    }
    @Test
    public void dropdownTest() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        try {
            Select select = new Select(driver.findElement(By.xpath("//select[@id='dropdown1']")));
            select.selectByVisibleText("Option 1");
        } catch (NoSuchElementException e) {
            System.out.println("Element not found!!");
        }


    }
}
