package com.lynn.selenium;

import com.lynn.selenium.facebookautomation.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginTest {

  static WebDriver driver;
  LoginPage loginPage;

  @BeforeAll
  static void setDriver() {
    WebDriverManager.chromedriver().setup();
  }

  @BeforeEach
  void setUp() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    driver = new ChromeDriver(options);
    driver.get("https://www.facebook.com/");
    loginPage = new LoginPage(driver);
  }

  @AfterAll
  static void teardown() {
    driver.quit();
  }

  @Test
  void login_Successfully_with_correct_credentials() {
    loginPage.getUsernameForm().sendKeys("oderolynn@gmail.com");
    loginPage.getPassword().sendKeys("123@Leona");
    loginPage.acceptCookies().click();
    loginPage.clickButton().click();
    WebElement facebookMenu = driver.findElement(
        By.xpath("//body/div[@id='mount_0_0_ww']/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/*[1]"));
    Assertions.assertTrue(facebookMenu.isDisplayed());
  }

  @Test
  void login_should_fail_with_incorrect_credentials() {
    loginPage.getUsernameForm().sendKeys("kels@yahoo.com");
    loginPage.getPassword().sendKeys("1232wesr");
    loginPage.acceptCookies().click();
    loginPage.clickButton().click();
    WebElement wrongPass = driver.findElement(
        By.xpath("//div[contains(text(),\"You've entered an old password\")]"));
    Assertions.assertTrue(wrongPass.isDisplayed());

  }


}
