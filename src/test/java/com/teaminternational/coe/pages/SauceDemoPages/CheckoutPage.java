package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public SelenideElement checkoutWlcMsg = $(".subheader_label"),
    firstNameField = $("[data-test='firstName']"),
    lastNameField = $("[data-test='lastName']"),
    zipCode = $("[data-test='postalCode']"),
    continueCheckoutBtn = $(".cart_checkout_link");

    public CheckoutPage() {
        checkoutWlcMsg.shouldBe(Condition.visible);
    }

    public void ContinueCheckout (String firstName, String lastName, String postalCode) {
        firstNameField.setValue(firstName);
        lastNameField.setValue(lastName);
        zipCode.setValue(postalCode);
        continueCheckoutBtn.click();

    }
}
