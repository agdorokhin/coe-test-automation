package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    public SelenideElement checkoutCompletePageWlcMsg = $(".subheader_label"),
    cartLblCounter = $(".fa-layers-counter"),
    completeHeader = $(".complete-header"),
    completeText = $(".complete-text"),
    completeImg = $(By.tagName("img"));


    public CheckoutCompletePage() {
        checkoutCompletePageWlcMsg.shouldBe(Condition.visible);
    }
}
