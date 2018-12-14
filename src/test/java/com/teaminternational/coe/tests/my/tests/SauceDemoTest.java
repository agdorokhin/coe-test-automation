package com.teaminternational.coe.tests.my.tests;

import com.codeborne.selenide.CollectionCondition;
import com.sun.webkit.WebPage;
import com.teaminternational.coe.tests.BaseCustomTest;
import com.teaminternational.coe.tests.my.tests.CartPage;
import com.teaminternational.coe.tests.my.tests.LoginPage;
import com.teaminternational.coe.tests.my.tests.ProductPage;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class SauceDemoTest extends BaseCustomTest {

    @Test
    public void testSauceDemo()  {
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

    }

}
