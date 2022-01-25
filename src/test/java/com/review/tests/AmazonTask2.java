package com.review.tests;

import com.review.pages.AmazonHomePage;
import com.review.pages.CartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTask2 extends TestBase{
   /* Task 001 :
            1. Go to https://www.amazon.com/
            2. Scroll down and scroll up on the main page
    3. Verify that, main page title contains "Amazon.com"
            4. Verify that, "Cart" is empty(0)
    5. Verify that, site language is "English"*/
    @Test
    public void test1() throws InterruptedException {
        AmazonHomePage amazonHomePage=new AmazonHomePage();

        //Scroll down and scroll up on the main page
        amazonHomePage.scrollDown();
        amazonHomePage.scrollUp();

        // Verify that, main page title contains "Amazon.com"
        Assert.assertTrue(amazonHomePage.mainPageTitle().contains("Amazon.com"));

        //Verify that, "Cart" is empty(0)
        CartPage cartPage=new CartPage();
        Assert.assertTrue(cartPage.cartIsEmpty().isDisplayed(),"Cart is not Empty");

        // Verify that, site language is "English"
        String expectedLanguage="English";
       Assert.assertEquals(amazonHomePage.language(),expectedLanguage,"Language is not English");
    }


}
