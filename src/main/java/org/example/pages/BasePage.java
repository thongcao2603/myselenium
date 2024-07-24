package org.example.pages;

import factories.ExplicitWaitFactory;
import org.example.constants.FrameworkConstants;
import org.example.driver.DriverManager;
import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reports.ExtentLogger;
import reports.ExtentManager;

import java.time.Duration;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();

    }

    protected void sendKeys(By by,String value, WaitStrategy waitStrategy){
       ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        ExtentLogger.pass("sendkeys success");
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }


}
