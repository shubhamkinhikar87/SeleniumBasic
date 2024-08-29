package com.selenium.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static void main(String[] args) throws IOException {
        Properties property = new Properties();
        String filename= System.getProperty("user.dir")+"/data.properties";
        property.load(new FileInputStream(filename));
        System.out.println(property.getProperty("url"));
        System.out.println(property.getProperty("username"));

    }
}
