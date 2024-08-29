package com.selenium.start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Paramterization {
    @Test
    @Parameters({"browser", "version"})
    public void test(String browser2, String version){
        System.out.println(browser2+"  "+version);
    }

}
