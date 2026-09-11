package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class InformationPom {

    private WebDriver driver;

  
    private By companyField =
            By.id("BillingNewAddress_Company");
    private By country = By.id("BillingNewAddress_CountryId");

   
    private By cityField =
            By.id("BillingNewAddress_City");

  
    private By addressField =
            By.id("BillingNewAddress_Address1");

   
    private By postalCodeField =
            By.id("BillingNewAddress_ZipPostalCode");

    
    private By phoneNumberField =
            By.id("BillingNewAddress_PhoneNumber");

   
    private By continueButton =
            By.cssSelector("input.new-address-next-step-button");

    public InformationPom(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCompany(String company) {
        driver.findElement(companyField).sendKeys(company);
    }

    public void enterCity(String city) {
        driver.findElement(cityField).sendKeys(city);
    }
    public void selectCountry() {
         Select select = new Select(driver.findElement(country)); select.selectByValue("33");
         }

    public void enterAddress(String address) {
        driver.findElement(addressField).sendKeys(address);
    }

    public void enterPostalCode(String postalCode) {
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }
}