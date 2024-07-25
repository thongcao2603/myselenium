package org.example.tests;

import org.example.pages.LoginPage;
import org.example.utils.DataProviderUtils;
import org.testng.annotations.Test;

import java.util.Map;

public class LoginPageTest extends BaseTest{

    private LoginPageTest(){}

    @Test(dataProvider = "getData",dataProviderClass = DataProviderUtils.class)
    public void test1(Map<String,String> data) {

        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername(data.get("username"));
        loginPage.enterPassword(data.get("password"));
    }



}
