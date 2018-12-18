package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public SelenideElement cartPageWlcMsg = $(".subheader_label");
    SelenideElement cartLblCounter = $(".fa-layers-counter");
    SelenideElement productQuantity = $(".cart_quantity");
    SelenideElement productName = $(".inventory_item_name");
    SelenideElement productDesc = $(".inventory_item_desc");
    SelenideElement productPrice = $(".inventory_item_price");
    SelenideElement checkoutBtn = $(".cart_checkout_link");

    public CartPage() {
        cartPageWlcMsg.shouldBe(Condition.visible);
    }

    public void Checkout() {
        if (checkoutBtn.isDisplayed()) {
            checkoutBtn.click();
        }
    }
}
