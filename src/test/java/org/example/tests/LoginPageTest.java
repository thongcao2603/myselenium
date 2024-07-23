package org.example.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("hello");
        Thread.sleep(3000);
    }
}
