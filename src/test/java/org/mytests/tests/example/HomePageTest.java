package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.hamcrest.Matchers.*;

import org.mytests.uiobjects.example.site.pages.ProductPage;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CUSTOMER;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.addOrRemoveBooks;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.checkOutForm;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.showCoupon;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
import static org.mytests.uiobjects.example.site.pages.ProductPage.*;
import static org.mytests.uiobjects.example.site.pages.ShopPage.*;
import static org.mytests.uiobjects.example.site.sections.CheckOutForm.*;

public class HomePageTest implements SimpleTestsInit {
    //Testcase 1 is not valid
    @Test
    public void testCase1() {
        topMenu.select("Shop");
        shopPage.checkOpened();
        breadcrumb.homeLink.click();
        homePage.checkOpened();
        slider.has().size(3);
    }

    //Testcase 2
    @Test
    public void verifyThreeArrivals(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
    }

    //Testcase 3,4,5,6
    @Test
    public void verifyArrivalsDetails() {
        homePage.verifyBookDetails();
    }

    //Testcase 7
    @Test
    public void addBasketWithMoreBooks() {
        homePage.clickBookWithPrice(500); // TODO: add method to extract price
        homePage.inputNumbersOfBooks(getNumbersInText(stockBooks)+1); // add quantity more than in-stock
        addToBasketBtn.click();
        inputStock.assertThat().attr("validationMessage",expectedStockMessage());
    }

    //Testcase 8
    @Test
    public void checkoutItems(){
        addBookToBasket(500);
        basketPage.checkOpened();
    }

    //Testcase 9
    @Test
    public void useCoupon(){
        homePage.clickBookWithPrice(500);
        addToBasketBtn.click();
        viewBasket.is().displayed();
        viewBasket.click();
        basketPage.checkOpened();
        basketPage.applyCoupon("krishnasakinala");
        cartDiscount.is().displayed();
        assertThat(actualDiscountAmount(), equalToIgnoringCase("₹50.00"));

        // there is a bug, sometime cookies are slow to be added to browser
        // which causes failure for the following test case
        // need to refresh to make sure we can clear this cookie before running other test
        getDriver().navigate().refresh();
    }

    //Testcase 10
    @Test
    public void userCouponLessThan450(){
        addBookToBasket(350);
        basketPage.applyCoupon("krishnasakinala");
        assertThat(actualErrorDiscountMessage(), equalToIgnoringCase("The minimum spend for this coupon is ₹450.00."));
    }

    //Testcase 11
    @Test
    public void removeBook(){
        addBookToBasket(350);
        removeBook.click();
        assertThat(emptyCartMessage(), equalToIgnoringCase("Your basket is currently empty."));
    }

    //Testcase 12
    @Test
    public void updateBasket(){
        addBookToBasket(350);
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
        addBookToBasket(350);
        addOrRemoveBooks(2);
        updateCart.click();
        spinner.waitFor().disappear();
        assertThat(subTotal.getText(), equalToIgnoringCase(expectedTotalPrice()));
    }

    //Testcase 15
    @Test
    public void checkTotalAndSubtotal(){
        addBookToBasket(350);
        assertThat(getPrice(subTotal.getText()), lessThan(getPrice(total.getText())));
    }

    //Testcase 16
    @Test
    public void verifyCheckOutPage(){
        addBookToBasket(350);
        checkOutBtn.click();
        checkOutPage.checkOpened();
    }

    //Testcase 17
    @Test
    public void paymentGateway() {
        addBookToBasket(500);
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
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        //arrivals.select(1);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        checkOutBtn.click();
        checkOutForm.placeOrder(DEFAULT_CUSTOMER);
        orderConfirmationPage.checkOpened();
    }
}
