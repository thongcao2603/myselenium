package org.example.driver;

import org.example.utils.ReadPropertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.Objects;

public class Driver {
    private Driver(){}


    public static void initDriver() throws Exception {
        //ngan khong cho tao them driver neu da ton tai
       if (Objects.isNull(DriverManager.getDriver())){
           DriverManager.setDriver(new ChromeDriver());
          DriverManager.getDriver().get(ReadPropertyFile.get("url"));
       }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
           DriverManager.getDriver().quit();
           DriverManager.closeDriver();
        }
    }
}
