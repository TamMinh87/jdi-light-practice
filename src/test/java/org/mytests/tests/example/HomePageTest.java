package org.mytests.tests.example;

import org.mytests.tests.SimpleTestsInit;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mytests.uiobjects.example.TestData.DEFAULT_CUSTOMER;
import static org.mytests.uiobjects.example.TestData.percy;
import static org.mytests.uiobjects.example.site.JdiTestSite.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.addOrRemoveBooks;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.checkOutForm;
import static org.mytests.uiobjects.example.site.pages.CheckOutPage.showCoupon;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;
import static org.mytests.uiobjects.example.site.pages.ShopPage.*;

public class HomePageTest implements SimpleTestsInit {
    //Testcase 1
    @Test
    public void testCase1() {
        topMenu.select("Shop");
        shopPage.checkOpened();
        breadcrumb.homeLink.click();
        homePage.checkOpened();
        slider.has().size(3);
        percy.snapshot("Test 1");
    }

    //Testcase 2
    @Test
    public void verifyThreeArrivals(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        percy.snapshot("Test 2");
    }

    //Testcase 3
    @Test
    public void verifyArrivalsNavigate() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        homePage.clickBookWithPrice(500);
        addToBasketBtn.is().displayed();
        percy.snapshot("Test 3");
    }

    //Testcase 4
    @Test
    public void verifyBookDescription() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        addToBasketBtn.is().displayed();
        descriptionLbl.is().displayed();
    }

    //Testcase 5
    @Test
    public void verifyBookReview() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        addToBasketBtn.is().displayed();
        reviewsLbl.is().displayed();
    }

    //Testcase 6
    @Test
    public void verifyArrivalsDetails() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        addToBasketBtn.is().displayed();
        addToBasketBtn.click();
        message.assertThat().text(containsString(expectedAddBasketMessage()));
        cartContents.is().text("1 Item");
    }

    //Testcase 7
    @Test
    public void addBasketWithMoreBooks() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        homePage.clickBookWithPrice(500);
        homePage.inputNumbersOfBooks(getNumbersInText(stockBooks)+1); // add quantity more than in-stock
        addToBasketBtn.click();
        inputStock.assertThat().attr("validationMessage",expectedStockMessage());
    }

    //Testcase 8
    @Test
    public void checkoutItems(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        basketPage.checkOpened();
    }
    //Testcase 9
    @Test
    public void useCoupon(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        basketPage.checkOpened();
        basketPage.applyCoupon("krishnasakinala");
        cartDiscount.is().displayed();
        discountAmount.is().text("₹50.00");
    }

    //Testcase 10
    @Test
    public void userCouponLessThan450(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Mastering JavaScript");
        productPage.checkOpened();
        productPage.addToBasket();
        basketPage.applyCoupon("krishnasakinala");
        assertThat(actualErrorDiscountMessage(), equalToIgnoringCase("The minimum spend for this coupon is ₹450.00."));
    }

    //Testcase 11
    @Test
    public void removeBook(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        removeBook.click();
        assertThat(emptyCartMessage(), equalToIgnoringCase("Your basket is currently empty."));
    }

    //Testcase 12
    @Test
    public void updateBasket(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
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
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        addOrRemoveBooks(2);
        updateCart.click();
        spinner.waitFor().disappear();
        assertThat(subTotal.getText(), equalToIgnoringCase(expectedTotalPrice()));
    }

    //Testcase 15
    @Test
    public void checkTotalAndSubtotal(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        assertThat(getPrice(subTotal.getText()), lessThan(getPrice(total.getText())));
    }

    //Testcase 16
    @Test
    public void verifyCheckOutPage(){
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        checkOutBtn.click();
        checkOutPage.checkOpened();
    }

    //Testcase 17
    @Test
    public void paymentGateway() {
        topMenu.select("Shop");
        breadcrumb.homeLink.click();
        arrivals.has().size(3);
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
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
        arrivals.select("Selenium Ruby");
        productPage.checkOpened();
        productPage.addToBasket();
        checkOutBtn.click();
        checkOutForm.placeOrder(DEFAULT_CUSTOMER);
        orderConfirmationPage.checkOpened();
    }
}
