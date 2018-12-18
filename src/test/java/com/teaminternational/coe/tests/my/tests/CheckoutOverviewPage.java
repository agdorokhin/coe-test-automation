package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckoutOverviewPage {
    public SelenideElement checkoutOverviewPageWlcMsg = $(".subheader_label");
    SelenideElement cartLblCounter = $(".fa-layers-counter");
    SelenideElement productName = $(".inventory_item_name");
    SelenideElement productDesc = $(".inventory_item_desc");
    SelenideElement productPrice = $(".inventory_item_price");
    SelenideElement productTotalQuantity = $(".summary_quantity");
    SelenideElement paymentInfo = $(byText("Payment Information:")).find(byXpath("./following-sibling::div[1]"));
    SelenideElement shippingInfo = $(byText("Shipping Information:")).find(byXpath("./following-sibling::div[1]"));
    SelenideElement productTotalPrice = $(".summary_subtotal_label");
    SelenideElement taxAmount = $(".summary_tax_label");
    SelenideElement totalSum = $(".summary_total_label");
    SelenideElement finishBtn = $(".cart_checkout_link");

    public CheckoutOverviewPage() {
        checkoutOverviewPageWlcMsg.shouldBe(Condition.visible);
    }

    public void CompleteCheckout() {
        if (finishBtn.isDisplayed()) {
            finishBtn.click();
        }
    }

}
