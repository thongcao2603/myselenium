package org.example.pages;

import factories.ExplicitWaitFactory;
import org.example.driver.DriverManager;
import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;

import reports.ExtentLogger;


public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy,String elementName){
        ExplicitWaitFactory.performExplicitWait(waitStrategy,by).click();
        try {
            ExtentLogger.pass(elementName+" is clicked",true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void sendKeys(By by,String value, WaitStrategy waitStrategy,String elementName){
       ExplicitWaitFactory.performExplicitWait(waitStrategy,by).sendKeys(value);
        try {
            ExtentLogger.pass(value +" is entered successfully in " +elementName,true);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }


}
