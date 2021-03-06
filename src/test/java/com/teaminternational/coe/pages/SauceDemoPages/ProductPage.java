package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProductPage {
    public SelenideElement productPageWlcMsg = $(".product_label"),
    cartLabel = $(".fa-layers-counter"),
    openCartBtn = $(".fa-shopping-cart");

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
