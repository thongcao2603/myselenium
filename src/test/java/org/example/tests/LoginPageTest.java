package org.example.tests;

import org.example.driver.Driver;
import org.example.driver.DriverManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void test1() throws InterruptedException {
       DriverManager.getDriver().findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(3000);
    }


    @Test
    public void test2() throws InterruptedException {
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(3000);
    }
}
