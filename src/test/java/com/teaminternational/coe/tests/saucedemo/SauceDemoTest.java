package com.teaminternational.coe.tests.saucedemo;

import com.codeborne.selenide.CollectionCondition;
import com.teaminternational.coe.pages.SauceDemoPages.*;
import com.teaminternational.coe.tests.BaseCustomTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SauceDemoTest extends BaseCustomTest {

    @DataProvider(name="ProductItems")
    public Object[][] getProductItem() {
        return new Object[][] {
                {"Onesie",
                        "Rib snap infant onesie for the junior automation engineer in development. " +
                        "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.",
                        "7.99",
                        "0.64",
                        "8.63"},
                {"Fleece Jacket",
                        "It's not every day that you come across a midweight quarter-zip fleece jacket "+
                        "capable of handling everything from a relaxing day outdoors to a busy day at the office",
                        "49.99",
                        "4",
                        "53.99"},
        };
    }

    @Test(dataProvider="ProductItems")
    public void RunTest (String productTitle, String productDesc, String productPrice, String taxAmount, String totalSum) {
        open("https://www.saucedemo.com");
        new LoginPage().login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage();

        productPage.productPageWlcMsg.shouldHave(text("Products"));
        productPage.productList().shouldHave(CollectionCondition.size(6));
        productPage.AddToCart(productTitle);
        productPage.cartLabel.shouldHave(text("1"));
        productPage.OpenCart();

        CartPage cartPage = new CartPage();
        cartPage.cartPageWlcMsg.shouldHave(text("Your cart"));
        cartPage.cartLblCounter.shouldHave(text("1"));
        cartPage.productQuantity.shouldHave(text("1"));
        cartPage.productName.shouldHave(text(productTitle));
        cartPage.productDesc.shouldHave(text(productDesc));
        cartPage.productPrice.shouldHave(text(productPrice));
        cartPage.Checkout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkoutWlcMsg.shouldHave(text("Checkout: Your Information"));
        checkoutPage.ContinueCheckout("Vasya", "Pupkin", "34312");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.checkoutOverviewPageWlcMsg.shouldHave(text("Checkout: Overview"));
        checkoutOverviewPage.cartLblCounter.shouldHave(text("1"));
        checkoutOverviewPage.productTotalQuantity.shouldHave(text("1"));
        checkoutOverviewPage.productName.shouldHave(text(productTitle));
        checkoutOverviewPage.productDesc.shouldHave(text(productDesc));
        checkoutOverviewPage.productPrice.shouldHave(text(productPrice));
        checkoutOverviewPage.paymentInfo.shouldHave(text("SauceCard #31337"));
        checkoutOverviewPage.shippingInfo.shouldHave(text("FREE PONY EXPRESS DELIVERY!"));
        checkoutOverviewPage.productTotalPrice.shouldHave(text(productPrice));
        checkoutOverviewPage.taxAmount.shouldHave(text(taxAmount));
        checkoutOverviewPage.totalSum.shouldHave(text(totalSum));
        checkoutOverviewPage.CompleteCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        checkoutCompletePage.cartLblCounter.shouldNotHave(text("1"));
        checkoutCompletePage.checkoutCompletePageWlcMsg.shouldHave(text("Checkout: Complete!"));
        checkoutCompletePage.completeHeader.shouldHave(text("THANK YOU FOR YOUR ORDER"));
        checkoutCompletePage.completeText.shouldHave(text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        checkoutCompletePage.completeImg.isDisplayed();


    }

}