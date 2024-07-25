package org.example.tests;

import org.example.pages.LoginPage;
import org.example.utils.DataProviderUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import reports.ExtentReport;

import java.util.Map;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void test1(Map<String,String> data) throws Exception {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(data.get("username"));
        loginPage.enterPassword(data.get("password"));
    }

    @Test()
    public void test2() throws Exception {
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("admin");
        loginPage.enterPassword("admin123");
    }


}
