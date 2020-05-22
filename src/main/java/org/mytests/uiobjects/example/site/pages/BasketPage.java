package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.elements.pageobjects.annotations.smart.SName;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.openqa.selenium.Keys;

import java.text.DecimalFormat;
import java.text.ParseException;

import static java.lang.Math.abs;
import static org.mytests.uiobjects.example.site.JdiTestSite.homePage;
import static org.mytests.uiobjects.example.site.pages.HomePage.*;

@Url("/basket/") @Title("Basket – Automation Practice Site")
public class BasketPage extends WebPage {
    @UI(".checkout-button") public static Button checkOutBtn;
    TextField couponCode;
    @UI("[name='apply_coupon']")Button applyCoupon;
    @UI("[name='update_cart']") public static Button updateCart;
    @UI("//input[@type='number']") public static TextField quantity;
    @UI(".cart-discount") public static UIElement cartDiscount;
    @UI("//td[contains(@data-title,'Coupon')]/span") public static Text discountAmount;
    @UI(".woocommerce-error") public static Text errorDiscountMessage;
    @UI(".cart-empty") public static Text emptyCartMessage;
    @UI(".remove") public static Button removeBook;
    @UI(".product-price>span") public static Text price;
    @UI(".product-subtotal>span") public static Text subTotal;
    @UI(".order-total .amount") public static Text total;
    @UI(".cart_totals>.blockOverlay") public static UIElement spinner;
    @SName Text acceptConditions;

    public void applyCoupon(String s){
        couponCode.sendKeys(s);
        applyCoupon.click();
    }

    public static String actualErrorDiscountMessage(){
        return errorDiscountMessage.getText();
    }

    public static String actualDiscountAmount(){
        return discountAmount.getText();
    }

    public static String emptyCartMessage(){
        return emptyCartMessage.getText();
    }

    public static void addOrRemoveBooks(int num){
        for(int i = 0; i < abs(num); i++){
            if(num>0)
                quantity.sendKeys(Keys.ARROW_UP);
            else
                quantity.sendKeys(Keys.ARROW_DOWN);
        }
    }

    public static String expectedTotalPrice(){
        int totalPrice = getNumbersInText(price)* Integer.parseInt(quantity.getValue());
        DecimalFormat df = new DecimalFormat("₹#,###.00");
        return df.format(totalPrice);
    }

    public static float getPrice (String s) {
        String pattern = "₹#,#.##";
        DecimalFormat df = new DecimalFormat(pattern);
        Number price = null;
        try {
            price = df.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return price.floatValue();
    }

    public static void addBookToBasket(int num){
        //homePage.open();
        homePage.clickImage(num);
        addToBasketBtn.click();
        viewBasket.click();
    }
}
