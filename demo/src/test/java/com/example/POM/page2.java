package com.example.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class page2 {

    private WebDriver driver;

   
    private By loginLink = By.className("ico-login");

  
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");

  
    private By rememberMe = By.id("RememberMe");

  
    private By loginButton = By.cssSelector("input.login-button");

    public page2(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickRememberMe() {
        driver.findElement(rememberMe).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }
}