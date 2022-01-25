package com.review.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.review.pages.AmazonHomePage;
import com.review.pages.CartPage;
import com.review.utilities.BrowserUtils;
import com.review.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTask1 extends TestBase {
   /*
Task 1: The task consists on the next steps:
Go to https://www.amazon.com
Search for "hats for men" (Call from Configuration.properties file)
Add the first hat appearing to Cart with quantity 2
Open cart and assert that the total price and quantity are correct
Reduce the quantity from 2 to 1 in Cart for the item selected in the step 3
Assert that the total price and quantity has been correctly changed
The goal of this test is to check if you are able to automate a test of a given website,
 but we'd like you to also demonstrate the coding quality, structure, and style of the deliverables.
*/
    @Test
    public void test1() throws InterruptedException {
        AmazonHomePage amazonHomePage=new AmazonHomePage();
        amazonHomePage.search();
        Thread.sleep(2000);
        amazonHomePage.firstitem.click();
        Select stateDropdown=new Select(amazonHomePage.quantityOfItem);
        stateDropdown.selectByIndex(1);
        amazonHomePage.addToCartButton.click();
        amazonHomePage.cartIcon.click();

        String expectedQuantity="2";
        String actualQuantity= stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualQuantity,expectedQuantity," quantity is not as expected");

        CartPage cartPage=new CartPage();
        double itemPrice=Double.parseDouble(cartPage.oneItemPrice.getText().substring(1));
        double totalPrice=itemPrice*2;


        //reduce quantity from 2 to 1
        stateDropdown.selectByIndex(1);

        //After reducing the quantity
        totalPrice=itemPrice;
        String reducedexpectedQuantity="1";
        String reducedactualQuantity= stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualQuantity,expectedQuantity," quantity is not as expected");

        //After reduced 1 item verify price has changed correctly
        Assert.assertEquals(itemPrice,totalPrice,"After reduced the quantity price has changed correctly");










    }

}
