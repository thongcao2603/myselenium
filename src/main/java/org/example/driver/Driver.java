package org.example.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

public class Driver {
    private Driver(){}


    public static void initDriver(String browser){
        //ngan khong cho tao them driver neu da ton tai
       if (Objects.isNull(DriverManager.getDriver())){
            if (browser.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                DriverManager.setDriver(new ChromeDriver());
            } else if (browser.equalsIgnoreCase("firefox")){
                WebDriverManager.firefoxdriver().setup();
                DriverManager.setDriver(new FirefoxDriver());
            }
            DriverManager.getDriver().get(PropertyUtils.get("url"));
       }
    }

    public static void quitDriver(){
        if (Objects.nonNull(DriverManager.getDriver())){
           DriverManager.getDriver().quit();
           DriverManager.closeDriver();
        }
    }
}
