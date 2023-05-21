package com.lynn.selenium.facebookautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
  WebDriver driver;

  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  public WebElement getUsernameForm(){
   return driver.findElement(By.id("email"));
  }

  public  WebElement getPassword(){
    return driver.findElement(By.id("pass"));
  }

  public  WebElement acceptCookies(){
    return driver.findElement(By.xpath("//button[@data-cookiebanner = 'accept_button']"));
  }
  public WebElement clickButton(){
    return driver.findElement(By.name("login"));
  }

}
