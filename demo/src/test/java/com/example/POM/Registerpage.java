package com.example.POM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registerpage {

    private WebDriver driver;

   
    private By registerLink = By.className("ico-register");

    private By genderMale = By.id("gender-male");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");
    private By registerButton = By.id("register-button");

   
    private By continueButton =By.cssSelector("input.register-continue-button");
    private By logoutLink = By.className("ico-logout");


    public  Registerpage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickRegisterLink() {
        driver.findElement(registerLink).click();
    }


    public void selectMale() {
        driver.findElement(genderMale).click();
    }


    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }


    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }


    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }


    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField)
              .sendKeys(confirmPassword);
    }


    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }


    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }


    public void clickLogout() {
        driver.findElement(logoutLink).click();
    }
}