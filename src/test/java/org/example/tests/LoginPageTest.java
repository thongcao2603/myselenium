package org.example.tests;

import org.example.driver.Driver;
import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void test1() throws InterruptedException {
       DriverManager.getDriver().findElement(By.name("q")).sendKeys("hello", Keys.ENTER);
       String actualTitle = DriverManager.getDriver().getTitle();
        Assert.assertEquals(actualTitle, "hello - Google Search");
    }


    @Test
    public void test2() throws InterruptedException {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(3000);
    }
}
