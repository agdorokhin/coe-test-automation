package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    public SelenideElement cartPageWlcMsg = $(".subheader_label"),
    cartLblCounter = $(".fa-layers-counter"),
    productQuantity = $(".cart_quantity"),
    productName = $(".inventory_item_name"),
    productDesc = $(".inventory_item_desc"),
    productPrice = $(".inventory_item_price"),
    checkoutBtn = $(".cart_checkout_link");

    public CartPage() {
        cartPageWlcMsg.shouldBe(Condition.visible);
    }

    public void Checkout() {
        if (checkoutBtn.isDisplayed()) {
            checkoutBtn.click();
        }
    }
}
