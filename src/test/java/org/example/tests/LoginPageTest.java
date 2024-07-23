package org.example.tests;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.BDDAssertions;
import org.example.driver.Driver;
import org.example.driver.DriverManager;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void test1() {
       LoginPage loginPage = new LoginPage();
       loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        HomePage homePage = loginPage.clickLogin();
        Assertions.assertThat(homePage.getPageTitle()).isEqualTo("OrangeHRM");
    }

}
