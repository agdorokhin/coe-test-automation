package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    public SelenideElement productPageWlcMsg = $(".product_label");
    public SelenideElement cartLabel = $(".fa-layers-counter");
    public SelenideElement openCartBtn = $(".fa-shopping-cart");

    public ProductPage(){
        productPageWlcMsg.shouldBe(Condition.visible);
    }

    public ElementsCollection productList() {
        return $$(".inventory_item");
    }

    public void AddToCart (String productName) {
        productList().findBy(text(productName)).find(".add-to-cart-button").click();
    }

    public void OpenCart() {
        if (openCartBtn.isDisplayed()) {
            openCartBtn.click();
        }
    }
}
