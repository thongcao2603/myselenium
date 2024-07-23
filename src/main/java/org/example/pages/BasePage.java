package org.example.pages;

import org.example.constants.FrameworkConstants;
import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected void click(By by, String waitStrategy){
        if (waitStrategy.equalsIgnoreCase("clickable")){
            explicitWaitForElementToBeClickable(by);
        } else if (waitStrategy.equalsIgnoreCase("present")){
            explicitWaitForElementToBePresent(by);
        }
        DriverManager.getDriver().findElement(by).click();
    }

    protected void sendKeys(By by,String value, String waitStrategy){
        if (waitStrategy.equalsIgnoreCase("clickable")){
            explicitWaitForElementToBeClickable(by);
        } else if (waitStrategy.equalsIgnoreCase("present")){
            explicitWaitForElementToBePresent(by);
        }
        DriverManager.getDriver().findElement(by).sendKeys(value);
    }

    private void explicitWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    private void explicitWaitForElementToBePresent(By by){
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWait()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
