package com.selenium.start;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TablePractice {
    private WebDriver driver;
    @BeforeTest
    public void initilizeTest(){
        driver = new ChromeDriver();

    }
    @Test
    public void tables() {
        driver.get("https://practice.expandtesting.com/dynamic-table");
        int row=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        int col=driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr[1]/td")).size();
        for(int i =1;i<=row; i++){
            for(int j=1;j<=col;j++){
                System.out.print(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr["+i+"]/td["+j+"]")).getText()+ "   ");
            }
            System.out.println();
        }


    }
}
