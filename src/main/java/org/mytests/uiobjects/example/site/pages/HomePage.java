package org.mytests.uiobjects.example.site.pages;

import com.epam.jdi.light.elements.common.*;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.*;
import com.epam.jdi.light.ui.html.elements.common.*;
import com.epam.jdi.light.ui.html.elements.common.Image;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

@Url("http://practice.automationtesting.in/") @Title("Automation Practice Site")
public class HomePage extends WebPage {
    @Css(".woocommerce-LoopProduct-link") public static List<WebElement> arrivals;
    @Css(".wp-post-image") public static List<WebElement> images;
    @UI("//button[@type='submit']") Button addToBasketBtn;
    @UI("//a[contains(text(),'Description')]") Label descriptionLbl;
    @UI("//a[contains(text(),'Reviews')]") Label reviewsLbl;
    @UI(".product_title") Text productTitle;
    @UI(".woocommerce-message") Text message;

    public void navigateImages(){
        for(WebElement e: images){
            e.click();
            addToBasketBtn.is().visible();
            addToBasketBtn.click();
            System.out.println("LONG+"+expectedMessageText());
            Assert.assertTrue(message.getText().contains(expectedMessageText()));
            scrollDown(300);
            descriptionLbl.is().visible();
            reviewsLbl.is().visible();
            back();
            back();
        }
    }

    public String expectedMessageText(){
        title = productTitle.getText();
        return '“' + title + '”' + " has been added to your basket.";
    }
}
