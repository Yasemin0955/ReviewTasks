package com.review.pages;

import com.review.utilities.ConfigurationReader;
import com.review.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AmazonHomePage extends BasePage{
    public void search(){

        searchInputbox.sendKeys(ConfigurationReader.get("item")+ Keys.ENTER);
    }

    @FindBy(css = "#quantity")
    public WebElement quantityOfItem;



    @FindBy(css = "#add-to-cart-button")
    public WebElement addToCartButton;

    @FindBy(xpath = "(//span[@class='icp-color-base'])[1]")
    public WebElement languageButton;


    JavascriptExecutor jse= (JavascriptExecutor) Driver.get();
    public void scrollDown() throws InterruptedException {
        jse.executeScript("window.scroll(0,document.body.scrollHeight)");
        Thread.sleep(2000);

    }
    public void scrollUp() throws InterruptedException {
        jse.executeScript("window.scroll(0,- document.body.scrollHeight)");
        Thread.sleep(2000);
    }
    public String mainPageTitle(){
        return Driver.get().getTitle();

    }
    public String language() throws InterruptedException {
        scrollDown();
        return languageButton.getText();


    }




}
