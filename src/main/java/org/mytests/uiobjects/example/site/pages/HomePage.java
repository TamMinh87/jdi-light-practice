package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.*;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.*;
import org.mytests.uiobjects.example.site.custom.Arrival;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;
import static org.mytests.uiobjects.example.site.pages.BasketPage.*;

@Url("http://practice.automationtesting.in/") @Title("Automation Practice Site")
public class HomePage extends WebPage {
    @UI(".n2-ss-slider-1 img") @GetAny public static JList<Image> slider;
    @UI(".products") public static JList<Arrival> arrivals;
    @UI(".wp-post-image") List<WebElement> images;
    @UI("//button[@type='submit']") public static Button addToBasketBtn;
    @UI("//a[contains(text(),'Description')]") Label descriptionLbl;
    @UI("//a[contains(text(),'Reviews')]") Label reviewsLbl;
    @UI(".product_title") Text productTitle;
    @UI(".woocommerce-message")
    public static Text message;
    @UI("//a[contains(text(),'Home')]") Link home;
    @UI(".in-stock") public static Text stockBooks;
    @UI("//input[@type='number']") public static TextField inputStock;
    @UI("//a[text()='View Basket']") public static Link viewBasket;
    //@UI(".price>.woocommerce-Price-amount") public static List<WebElement> bookPrice;
    @UI(".price") public static List<WebElement> bookPrice;


    public void verifyBookDetails() {
        int i = 0;
        for(WebElement e: images){
            e.click();
            addToBasketBtn.is().displayed();
            addToBasketBtn.click();
            message.assertThat().text(containsString(expectedAddBasketMessage()));
            descriptionLbl.is().displayed();
            reviewsLbl.is().displayed();
            if(++i == images.size())
                break;
            home.click();
        }
    }

    public void inputNumbersOfBooks(int number){
        inputStock.clear();
        inputStock.sendKeys(String.valueOf(number));
    }

    public String expectedAddBasketMessage(){
        title = productTitle.getText();
        return '“' + title + '”' + " has been added to your basket.";
    }

    public static String expectedStockMessage(){
        String numberInStock = String.valueOf(getNumbersInText(stockBooks));
        return "Value must be less than or equal to " + numberInStock + ".";
    }

    public void clickBookWithPrice(float num){
        for(WebElement e: bookPrice) {
            String price;
            String[] s = e.getAttribute("textContent").split(" ");

            if(s.length==2)
                price = s[1];
            else
                price = s[0];

            if(num == getPrice(price)){
                e.click();
                break;
            }
        }
    }

    public static int getNumbersInText(Text t){
        String string = t.getText();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(string);
        m.find();
        return Integer.parseInt(m.group());
    }
}
