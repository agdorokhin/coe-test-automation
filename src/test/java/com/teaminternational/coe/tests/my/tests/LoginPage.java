package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public SelenideElement username = $("[data-test='username']");
    SelenideElement password = $("[data-test='password']");
    SelenideElement loginBtn = $(".login-button");

    public void login (String user, String pwd) {
        username.setValue(user);
        password.setValue(pwd);
        loginBtn.click();
        //return new LoginPage();

    }
}