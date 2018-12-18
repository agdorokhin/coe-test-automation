package com.teaminternational.coe.pages.SauceDemoPages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutOverviewPage {
    public SelenideElement checkoutOverviewPageWlcMsg = $(".subheader_label"),
    cartLblCounter = $(".fa-layers-counter"),
    productName = $(".inventory_item_name"),
    productDesc = $(".inventory_item_desc"),
    productPrice = $(".inventory_item_price"),
    productTotalQuantity = $(".summary_quantity"),
    paymentInfo = $(byText("Payment Information:")).find(byXpath("./following-sibling::div[1]")),
    shippingInfo = $(byText("Shipping Information:")).find(byXpath("./following-sibling::div[1]")),
    productTotalPrice = $(".summary_subtotal_label"),
    taxAmount = $(".summary_tax_label"),
    totalSum = $(".summary_total_label"),
    finishBtn = $(".cart_checkout_link");

    public CheckoutOverviewPage() {
        checkoutOverviewPageWlcMsg.shouldBe(Condition.visible);
    }

    public void CompleteCheckout() {
        if (finishBtn.isDisplayed()) {
            finishBtn.click();
        }
    }

}
