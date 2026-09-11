package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPom {

    private WebDriver driver;

   
    private By shoppingCart =
            By.cssSelector("span.cart-label");

  
    private By termsOfService =
            By.id("termsofservice");

  
    private By checkoutButton =By.id("checkout");

    public ShoppingCartPom(WebDriver driver) {
        this.driver = driver;
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    public void selectTermsOfService() {
        driver.findElement(termsOfService).click();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}