package org.example.pages;

import org.example.driver.DriverManager;

public class HomePage {

    public String getPageTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
