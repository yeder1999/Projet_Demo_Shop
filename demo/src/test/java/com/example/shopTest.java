package com.example;
//import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.POM.Registerpage;
import com.example.POM.page2;
import com.example.POM.addcartpage;
import com.example.POM.ShoppingCartPom;
import com.example.POM.InformationPom;
import com.example.POM.PaymentPom;

public class shopTest {

private WebDriver driver;
private WebDriverWait wait;

private Registerpage registerPage;
private page2 loginPage;
private addcartpage addCartPage;
private ShoppingCartPom shoppingCartPage;
private InformationPom informationPage;
private PaymentPom paymentPage;

@BeforeEach
public void setUp() {

   URL gridUrl = null;

         try {
        gridUrl = new URL("http://127.0.0.1:4444");
         } catch (MalformedURLException e) {
        e.printStackTrace();
        }

    ChromeOptions cr = new ChromeOptions();

    driver.manage() .timeouts().implicitlyWait(Duration.ofSeconds(10));

    driver.manage().window().maximize();

    driver.get("https://demowebshop.tricentis.com/");

    wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    registerPage = new Registerpage(driver);
    loginPage = new page2(driver);
    addCartPage = new addcartpage(driver);
    shoppingCartPage = new ShoppingCartPom(driver);
    informationPage = new InformationPom(driver);
    paymentPage = new PaymentPom(driver);
}

@Test
@Tag("smoke")
public void completeShoppingJourneyTest() {

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

    assertEquals("https://demowebshop.tricentis.com/",driver.getCurrentUrl());

    registerPage.clickRegisterLink();

    wait.until(ExpectedConditions.urlToBe( "https://demowebshop.tricentis.com/register"));

    registerPage.selectMale();
    registerPage.enterFirstName("yeidr");
    registerPage.enterLastName("benamar");

    String email ="yedir" + System.currentTimeMillis() + "@test.com";

    registerPage.enterEmail(email);
    registerPage.enterPassword("Yedir1999##!");
    registerPage.enterConfirmPassword("Yedir1999##!");
    registerPage.clickRegisterButton();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/registerresult/1"));

    assertEquals("https://demowebshop.tricentis.com/registerresult/1",driver.getCurrentUrl());

    registerPage.clickContinueButton();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ico-logout")));

    assertTrue(driver.getPageSource().contains("Log out"));

    registerPage.clickLogout();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

    loginPage.clickLoginLink();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));
    //methode optimal apres 
    loginPage.enterEmail(email);
    loginPage.enterPassword("Yedir1999##!");
    loginPage.clickRememberMe();
    loginPage.clickLoginButton();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/"));

    addCartPage.clickAddToCartFromHome();

    wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/25-virtual-gift-card"));

    assertEquals( "https://demowebshop.tricentis.com/25-virtual-gift-card", driver.getCurrentUrl());

    addCartPage.enterRecipientName("Yeidr Benamar");
    addCartPage.enterRecipientEmail(email);
    addCartPage.clickAddToCartButton();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#bar-notification")));

    assertTrue(addCartPage.getSuccessMessage().contains("The product has been added to your shopping cart"));

    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#bar-notification")));

    wait.until(ExpectedConditions.elementToBeClickable( By.cssSelector("span.cart-label")));

    shoppingCartPage.clickShoppingCart();

    wait.until(ExpectedConditions.urlContains("/cart"));
shoppingCartPage.selectTermsOfService();shoppingCartPage.clickCheckout();

    wait.until(ExpectedConditions.urlContains("/onepagecheckout"));

    informationPage.enterCompany("Test Company");
    informationPage.selectCountry();
    informationPage.enterCity("Paris");
    informationPage.enterAddress("10 rue de Paris");
    informationPage.enterPostalCode("75001");
    informationPage.enterPhoneNumber("0600000000");
    informationPage.clickContinue();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("paymentmethod_2")));

    paymentPage.selectCreditCard();
    paymentPage.clickPaymentMethodContinue();

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("CreditCardType")));

    paymentPage.selectVisa();
    paymentPage.enterCardholderName("bahae");
    paymentPage.enterCardNumber("424242424242");
    paymentPage.selectExpireMonth("1");
    paymentPage.selectExpireYear("2027");
    paymentPage.enterCardCode("123");

paymentPage.clickPaymentInfoContinue();

wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input.confirm-order-next-step-button"))
);

paymentPage.clickConfirmOrder();

wait.until( ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/checkout/completed/")
);

assertEquals( "https://demowebshop.tricentis.com/checkout/completed/", driver.getCurrentUrl()
);
}

@AfterEach
public void tearDown() {

    if (driver != null) {
        driver.quit();
    }
}


}
