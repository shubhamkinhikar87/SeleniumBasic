package com.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://app.vwo.com/");
        Login_POM loginPom= new Login_POM(driver);
        loginPom.Login_VWO("skinhikar@gmail.com","Test@123");
    }

}
