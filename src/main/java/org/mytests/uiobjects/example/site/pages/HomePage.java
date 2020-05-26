package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.*;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.*;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Url("http://practice.automationtesting.in/") @Title("Automation Practice Site")
public class HomePage extends WebPage {
    @UI(".woocommerce-LoopProduct-link") public static List<WebElement> arrivals;
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

    public void navigateImages() {
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

    public void clickImage(int i){
        arrivals.get(i).click();
    }

    public static int getNumbersInText(Text t){
        String string = t.getText();
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(string);
        m.find();
        return Integer.parseInt(m.group());
    }
}
