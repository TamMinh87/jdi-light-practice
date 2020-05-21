package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;

import static org.hamcrest.Matchers.*;

import org.mytests.uiobjects.example.site.sections.CheckOutForm;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CUSTOMER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.addOrRemoveBooks;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.checkOutForm;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
import static org.mytests.uiobjects.example.site.sections.CheckOutForm.*;


public class HomePageTest implements SimpleTestsInit {
    @Test
    public void verifyThreeArrivals(){
        homePage.open();
        assertThat(arrivals, hasSize(3));
    }

    @Test
    public void verifyArrivalsDetails() {
        homePage.open();
        homePage.navigateImages();
    }

    @Test
    public void addBasketWithMoreBooks() {
        homePage.open();
        homePage.clickImage(0);
        homePage.inputNumbersOfBooks(getNumbersInText(stockBooks)+1);
        addToBasketBtn.click();
        inputStock.assertThat().attr("validationMessage",expectedStockMessage());
    }

    @Test
    public void checkoutItems(){
        addBookToBasket(0);
        viewBasket.click();
        basketPage.checkOpened();
    }

    @Test
    public void useCoupon(){
        homePage.open();
        homePage.clickImage(0);
        addToBasketBtn.click();
        viewBasket.is().displayed();
        viewBasket.click();
        basketPage.checkOpened();
        basketPage.applyCoupon("krishnasakinala");
        cartDiscount.is().displayed();
        assertThat(actualDiscountAmount(), equalToIgnoringCase("₹50.00"));
    }

    @Test
    public void userCouponLessThan450(){
        addBookToBasket(2);
        basketPage.applyCoupon("krishnasakinala");
        assertThat(actualErrorDiscountMessage(), equalToIgnoringCase("The minimum spend for this coupon is ₹450.00."));
    }

    @Test
    public void removeBook(){
        addBookToBasket(2);
        removeBook.click();
        assertThat(emptyCartMessage(), equalToIgnoringCase("Your basket is currently empty."));
    }

    @Test
    public void updateBasket(){
        addBookToBasket(2);
        updateCart.is().disabled();
        addOrRemoveBooks(2);
        updateCart.is().enabled();
        updateCart.click();
        updateCart.is().disabled();
        assertThat(quantity.getText(), equalToIgnoringCase("3"));
        addOrRemoveBooks(-2);
        updateCart.is().enabled();
        updateCart.click();
        updateCart.is().disabled();
        assertThat(quantity.getText(), equalToIgnoringCase("1"));
    }

    @Test
    public void totalPrice(){
        addBookToBasket(2);
        addOrRemoveBooks(2);
        updateCart.click();
        spinner.waitFor().disappear();
        assertThat(subTotal.getText(), equalToIgnoringCase(expectedTotalPrice()));
    }

    @Test
    public void checkTotalAndSubtotal(){
        addBookToBasket(2);
        assertThat(getPrice(subTotal.getText()), lessThan(getPrice(total.getText())));
    }

    @Test
    public void verifyCheckOutPage(){
        addBookToBasket(2);
        checkOutBtn.click();
        checkOutPage.checkOpened();
    }

    @Test
    public void paymentGateway() {
        addBookToBasket(2);
        checkOutBtn.click();
        checkOutForm.selectCountry("Vatican");
        checkOutForm.fill(DEFAULT_CUSTOMER);
        placeOrder.click();
    }
}
