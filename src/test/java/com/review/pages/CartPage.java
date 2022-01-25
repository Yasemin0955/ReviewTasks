package com.review.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{


@FindBy(css="#sc-subtotal-amount-activecart")
    public WebElement totalPriceinCart;

@FindBy(xpath = "//p[@class='a-spacing-mini']/span")
    public WebElement oneItemPrice;

@FindBy(xpath = "//h2")
    public WebElement cartIsEmptyMessage;
public WebElement cartIsEmpty(){
    cartIcon.click();
    return cartIsEmptyMessage;


}









}
