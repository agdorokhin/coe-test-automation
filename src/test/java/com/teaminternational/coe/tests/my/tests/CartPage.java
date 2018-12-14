package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CartPage {
    SelenideElement cartPageWlcMsg = $(".subheader_label");
    SelenideElement productName = $("inventory_item_name");
    SelenideElement productDesc = $("inventory_item_desc");
    SelenideElement checkoutBtn = $("cart_checkout_link");

}
