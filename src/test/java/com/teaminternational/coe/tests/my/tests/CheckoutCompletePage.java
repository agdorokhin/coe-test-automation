package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutCompletePage {
    public SelenideElement checkoutCompletePageWlcMsg = $(".subheader_label");
    SelenideElement cartLblCounter = $(".fa-layers-counter");
    SelenideElement completeHeader = $(".complete-header");
    SelenideElement completeText = $(".complete-text");
    SelenideElement completeImg = $(By.tagName("img"));


    public CheckoutCompletePage() {
        checkoutCompletePageWlcMsg.shouldBe(Condition.visible);
    }
}
