package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    SelenideElement firstNameField = $("[data-test='firstName']");
    SelenideElement lastNameField = $("[data-test='lastName']");
    SelenideElement zipCode = $("[data-test='postalCode']");
    SelenideElement continueCheckoutBtn = $("cart_checkout_link");
}
