package org.example.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By inputEmail= By.name("username");
    private final By inputPassword= By.name("password");
    private final By buttonLogin=By.xpath("//button[normalize-space()='Login']");

    public LoginPage enterUsername(String username) {
        sendKeys(inputEmail,username,"present");
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(inputPassword,password,"present");
        return this;
    }

    public HomePage clickLogin() {
        click(buttonLogin,"clickable");
        return new HomePage();
    }

}
