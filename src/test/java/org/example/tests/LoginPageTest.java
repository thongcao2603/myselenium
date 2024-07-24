package org.example.tests;

import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ExtentReport;

import java.util.Map;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test
    public void test1() {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");
    }

    @Test
    public void test2() {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");
    }


}
