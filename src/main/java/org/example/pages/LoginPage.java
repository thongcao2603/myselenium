package org.example.pages;

import org.example.enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By inputEmail= By.name("username");
    private final By inputPassword= By.name("password");
    private final By buttonLogin=By.xpath("//button[normalize-space()='Login']");

    public LoginPage enterUsername(String username) {
        sendKeys(inputEmail,username, WaitStrategy.PRESENCE,"Textbox username");
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(inputPassword,password,WaitStrategy.PRESENCE,"Textbox password");
        return this;
    }

    public HomePage clickLogin(){
        click(buttonLogin,WaitStrategy.CLICKABLE, "Button login");
        return new HomePage();
    }

}
