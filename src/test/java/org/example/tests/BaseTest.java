package org.example.tests;

import org.example.driver.Driver;
import org.example.utils.PropertyUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected BaseTest(){

    }

    @BeforeMethod
    public void setUp() {
        Driver.initDriver(PropertyUtils.get("browser"));
    }

    @AfterMethod
    public void tearDown() {
        Driver.quitDriver();
    }

}
