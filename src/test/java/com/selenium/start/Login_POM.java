package com.selenium.start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_POM {

    private WebDriver driver;
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By submitButton = By.id("js-login-btn");

     public Login_POM(WebDriver driver){
        this.driver =driver;
    }
    public void Login_VWO(String username, String password){
        driver.findElement(this.username).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.submitButton).click();
    }
}
