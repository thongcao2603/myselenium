package org.example.tests;

import org.example.driver.Driver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void test1() throws InterruptedException {
        Driver.driver.findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(3000);
    }
}
