package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PaymentPom {

    private WebDriver driver;

 
    private By creditCard =By.id("paymentmethod_2");

    private By paymentMethodContinue =By.cssSelector("input.payment-method-next-step-button");

  
    private By creditCardType =By.id("CreditCardType");

  
    private By cardholderName =By.id("CardholderName");


    private By cardNumber =By.id("CardNumber");
    /// button confirm
    private By confirmOrderButton =By.cssSelector("input.confirm-order-next-step-button");
   
    private By expireYear =By.id("ExpireYear");
    private By cardBy= By.id("CardCode");

    
    private By paymentInfoContinue =By.cssSelector("input.payment-info-next-step-button");

    public PaymentPom(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCreditCard() {
        driver.findElement(creditCard).click();
    }

    public void clickPaymentMethodContinue() {
        driver.findElement(paymentMethodContinue).click();
    }
    public void enterCardCode(String code) {
        driver.findElement(cardBy).sendKeys(code);
    }

    public void selectVisa() {
        Select select = new Select(
            driver.findElement(creditCardType)
        );

        select.selectByValue("Visa");
    }

    public void enterCardholderName(String name) {
        driver.findElement(cardholderName).sendKeys(name);
    }

    public void enterCardNumber(String number) {
        driver.findElement(cardNumber).sendKeys(number);
    }

    public void selectExpireYear(String year) {
        Select select = new Select(
            driver.findElement(expireYear)
        );

        select.selectByValue(year);
    }
    // methode confirm
    public void clickConfirmOrder() {
    driver.findElement(confirmOrderButton).click();
}

    public void clickPaymentInfoContinue() {
        driver.findElement(paymentInfoContinue).click();
    }
}