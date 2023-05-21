package com.lynn.selenium.facebookautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
  WebDriver driver;

  public  WebElement acceptCookies() {
    return driver.findElement(By.xpath("//button[@data-cookiebanner = 'accept_button']"));
  }
  public ForgotPasswordPage(WebDriver driver){
    this.driver = driver;
  }
  public WebElement clickForgotPassword(){
    return driver.findElement(By.xpath("//a[contains(text(),'Forgotten password?')]"));
  }

  public WebElement enterEmailAdress(){
    return driver.findElement(By.xpath("//input[@id='identify_email']"));
  }
  public WebElement searchEmail(){
    return driver.findElement(By.xpath("//button[@id='did_submit']"));
  }
  public WebElement continueButton(){
    return driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
  }

}
