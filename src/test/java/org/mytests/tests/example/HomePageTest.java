package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CUSTOMER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.addOrRemoveBooks;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.checkOutForm;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.showCoupon;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
import static org.mytests.uiobjects.example.site.sections.CheckOutForm.*;


public class HomePageTest implements SimpleTestsInit {
    //Testcase 1 is not valid

    //Testcase 2
    @Test
    public void verifyThreeArrivals(){
        assertThat(arrivals, hasSize(3));
    }

    //Testcase 3,4,5,6
    @Test
    public void verifyArrivalsDetails() {
        homePage.navigateImages();
    }

    //Testcase 7
    @Test
    public void addBasketWithMoreBooks() {
        homePage.clickImage(0);
        homePage.inputNumbersOfBooks(getNumbersInText(stockBooks)+1);
        addToBasketBtn.click();
        inputStock.assertThat().attr("validationMessage",expectedStockMessage());
    }

    //Testcase 8
    @Test
    public void checkoutItems(){
        addBookToBasket(0);
        basketPage.checkOpened();
    }

    //Testcase 9
    @Test
    public void useCoupon(){
        homePage.clickImage(0);
        addToBasketBtn.click();
        viewBasket.is().displayed();
        viewBasket.click();
        basketPage.checkOpened();
        basketPage.applyCoupon("krishnasakinala");
        cartDiscount.is().displayed();
        assertThat(actualDiscountAmount(), equalToIgnoringCase("₹50.00"));
        getDriver().navigate().refresh();
    }

    //Testcase 10
    @Test
    public void userCouponLessThan450(){
        addBookToBasket(2);
        basketPage.applyCoupon("krishnasakinala");
        assertThat(actualErrorDiscountMessage(), equalToIgnoringCase("The minimum spend for this coupon is ₹450.00."));
    }

    //Testcase 11
    @Test
    public void removeBook(){
        addBookToBasket(2);
        removeBook.click();
        assertThat(emptyCartMessage(), equalToIgnoringCase("Your basket is currently empty."));
    }

    //Testcase 12
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

    //Testcase 13,14
    @Test
    public void totalPrice(){
        addBookToBasket(2);
        addOrRemoveBooks(2);
        updateCart.click();
        spinner.waitFor().disappear();
        assertThat(subTotal.getText(), equalToIgnoringCase(expectedTotalPrice()));
    }

    //Testcase 15
    @Test
    public void checkTotalAndSubtotal(){
        addBookToBasket(2);
        assertThat(getPrice(subTotal.getText()), lessThan(getPrice(total.getText())));
    }

    //Testcase 16
    @Test
    public void verifyCheckOutPage(){
        addBookToBasket(2);
        checkOutBtn.click();
        checkOutPage.checkOpened();
    }

    //Testcase 17
    @Test
    public void paymentGateway() {
        addBookToBasket(0);
        checkOutBtn.click();
        showCoupon.is().displayed();
        showCoupon.click();
        basketPage.applyCoupon("krishnasakinala");
        assertThat(message.getText(), equalToIgnoringCase("Coupon code applied successfully."));
        homePage.open();
    }

    //Testcase 18
    @Test
    public void orderConfirmation() {
        addBookToBasket(0);
        checkOutBtn.click();
        checkOutForm.selectCountry("Vietnam");
        checkOutForm.fill(DEFAULT_CUSTOMER);
        placeOrder.click();
        orderConfirmationPage.checkOpened();
    }
}
