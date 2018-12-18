package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {
    public SelenideElement checkoutWlcMsg = $(".subheader_label");
    SelenideElement firstNameField = $("[data-test='firstName']");
    SelenideElement lastNameField = $("[data-test='lastName']");
    SelenideElement zipCode = $("[data-test='postalCode']");
    SelenideElement continueCheckoutBtn = $(".cart_checkout_link");

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
