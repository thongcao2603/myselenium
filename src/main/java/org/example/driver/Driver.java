package org.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Objects;

public class Driver {
    public static WebDriver driver;

    public static void initDriver(){
        //ngan khong cho tao them driver neu da ton tai
       if (Objects.isNull(driver)){
           driver=new ChromeDriver();
           driver.get("https://www.google.com");
       }
    }

    public static void quitDriver(){
        if (Objects.nonNull(driver)){
            driver.quit();
            driver = null;
        }
    }
}
