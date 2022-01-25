package com.review.pages;

import com.review.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css ="#twotabsearchtextbox")
   public WebElement searchInputbox;
    @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public WebElement firstitem;

    @FindBy(id = "nav-cart")
    public WebElement cartIcon;

}
