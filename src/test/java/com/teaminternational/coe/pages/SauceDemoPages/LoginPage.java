package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement username = $("[data-test='username']"),
    password = $("[data-test='password']"),
    loginBtn = $(".login-button");

    public void login (String user, String pwd) {
        username.setValue(user);
        password.setValue(pwd);
        loginBtn.click();
        //return new LoginPage();
    }
}