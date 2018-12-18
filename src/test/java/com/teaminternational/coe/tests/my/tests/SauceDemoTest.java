package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.CollectionCondition;
import com.teaminternational.coe.tests.BaseCustomTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SauceDemoTest extends BaseCustomTest {

    @Test
    public void SauceDemoTest()  {
        open("https://www.saucedemo.com");
        new LoginPage().login("standard_user", "secret_sauce");

        ProductPage productPage = new ProductPage();

        productPage.productPageWlcMsg.shouldHave(text("Products"));
        productPage.productList().shouldHave(CollectionCondition.size(6));
        productPage.AddToCart("Onesie");
        productPage.cartLabel.shouldHave(text("1"));
        productPage.OpenCart();

        CartPage cartPage = new CartPage();
        cartPage.cartPageWlcMsg.shouldHave(text("Your cart"));
        cartPage.cartLblCounter.shouldHave(text("1"));
        cartPage.productQuantity.shouldHave(text("1"));
        cartPage.productName.shouldHave(text("Sauce Labs Onesie"));
        cartPage.productDesc.shouldHave(text("Rib snap infant onesie for the junior automation engineer in development. " +
                "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."));
        cartPage.productPrice.shouldHave(text("7.99"));
        cartPage.Checkout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkoutWlcMsg.shouldHave(text("Checkout: Your Information"));
        checkoutPage.ContinueCheckout("Vasya", "Pupkin","34312");

        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutOverviewPage.checkoutOverviewPageWlcMsg.shouldHave(text("Checkout: Overview"));
        checkoutOverviewPage.cartLblCounter.shouldHave(text("1"));
        checkoutOverviewPage.productTotalQuantity.shouldHave(text("1"));
        checkoutOverviewPage.productName.shouldHave(text("Sauce Labs Onesie"));
        checkoutOverviewPage.productDesc.shouldHave(text("Rib snap infant onesie for the junior automation engineer in development. " +
                "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel."));
        checkoutOverviewPage.productPrice.shouldHave(text("7.99"));
        checkoutOverviewPage.paymentInfo.shouldHave(text("SauceCard #31337"));
        checkoutOverviewPage.shippingInfo.shouldHave(text("FREE PONY EXPRESS DELIVERY!"));
        checkoutOverviewPage.productTotalPrice.shouldHave(text("7.99"));
        checkoutOverviewPage.taxAmount.shouldHave(text("0.64"));
        checkoutOverviewPage.totalSum.shouldHave(text("8.63"));
        checkoutOverviewPage.CompleteCheckout();

        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();
        checkoutCompletePage.cartLblCounter.shouldNotHave(text("1"));
        checkoutCompletePage.checkoutCompletePageWlcMsg.shouldHave(text("Checkout: Complete!"));
        checkoutCompletePage.completeHeader.shouldHave(text("THANK YOU FOR YOUR ORDER"));
        checkoutCompletePage.completeText.shouldHave(text("Your order has been dispatched, and will arrive just as fast as the pony can get there!"));
        checkoutCompletePage.completeImg.isDisplayed();


    }

}