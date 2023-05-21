package com.lynn.selenium;

import com.lynn.selenium.facebookautomation.ForgotPasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.test.context.event.annotation.BeforeTestClass;

public class ForgotPasswordTest {
  WebDriver driver;
  ForgotPasswordPage forgotPasswordPage;

  @BeforeAll
  static void setUpDriverManager(){
    WebDriverManager.chromedriver().setup();
  }
  @BeforeEach
  void setUp(){
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.get("https://www.facebook.com/");
    forgotPasswordPage = new ForgotPasswordPage(driver);
  }

  @Test
  void forgotPasswordTest(){
    forgotPasswordPage.acceptCookies().click();
    forgotPasswordPage.clickForgotPassword().click();
    forgotPasswordPage.enterEmailAdress().sendKeys("keneth@yahoo.com");
    forgotPasswordPage.searchEmail().click();
    forgotPasswordPage.continueButton().click();
  }

}
