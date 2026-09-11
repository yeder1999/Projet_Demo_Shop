package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class addcartpage {

    private WebDriver driver;

   
    private By addToCartHome =
            By.cssSelector("input.product-box-add-to-cart-button");

  
    private By recipientName =
            By.id("giftcard_2_RecipientName");

    private By recipientEmail =
            By.id("giftcard_2_RecipientEmail");

    private By addToCartButton =
            By.id("add-to-cart-button-2");

    
    private By successMessage =
            By.cssSelector(".bar-notification.success");

    public addcartpage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCartFromHome() {
        driver.findElement(addToCartHome).click();
    }

    public void enterRecipientName(String name) {
        driver.findElement(recipientName).sendKeys(name);
    }

    public void enterRecipientEmail(String email) {
        driver.findElement(recipientEmail).sendKeys(email);
    }

    public void clickAddToCartButton() {
        driver.findElement(addToCartButton).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}