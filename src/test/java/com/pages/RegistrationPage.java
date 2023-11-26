package com.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

public class RegistrationPage {
	
	WebDriver driver;
	

	By firstName=By.xpath("//*[@name=\"firstName\"]");
	
	By lastName=By.xpath("//*[@name=\"lastName\"]");
	
	By phone=By.xpath("//*[@name=\"phone\"]");
	
	By address=By.xpath("//*[@name=\"address1\"]");
	
	By city=By.xpath("//*[@name=\"city\"]");
	
	By state=By.xpath("//*[@name=\"state\"]");
	
	By postalCode=By.xpath("//*[@name=\"postalCode\"]");
	
	By userName=By.xpath("//*[@name=\"email\"]");
	
	
	By password=By.xpath("//*[@name=\"password\"]");
	
	By confirmPassword=By.xpath("//*[@name=\"confirmPassword\"]");
	
	By submitButton=By.xpath("//*[@name=\"submit\"]");
	
	By passwordMessage=By.xpath("//*[text()=\"PAssword and con.password does not match\"]");
	
	public void verifyPassword(WebDriver driver) {
		driver.findElement(password).sendKeys("abc");
		driver.findElement(confirmPassword).sendKeys("123");
		driver.findElement(submitButton).click();
		
		driver.manage().addCookie(new Cookie("key", "value"));
		Assert.assertTrue(driver.findElement(passwordMessage).isDisplayed());
		takeScreenshots(driver,"test1.jpg");
		
	}
	
	public void enterDetails(WebDriver driver,String Name, String surName,String phone1, String address1,String city1,String state1, String postalCode1, String username1, String password1) {
		driver.findElement(firstName).sendKeys(Name);
		driver.findElement(lastName).sendKeys(surName);
		driver.findElement(phone).sendKeys(phone1);
		driver.findElement(address).sendKeys(address1);
		driver.findElement(city).sendKeys(city1);
		
		driver.findElement(state).sendKeys(state1);
		driver.findElement(postalCode).sendKeys(postalCode1);
		driver.findElement(userName).sendKeys(username1);
		driver.findElement(password).sendKeys(password1);
		driver.findElement(confirmPassword).sendKeys(password1);
		
		driver.findElement(submitButton).click();
		takeScreenshots(driver,"test2.jpg");
	}
	
	public void takeScreenshots(WebDriver driver,String nameOfScreenshot) {
		  //to take screenshot - observe below code

        TakesScreenshot ts = (TakesScreenshot)driver;   
        File srcFIle = ts.getScreenshotAs(OutputType.FILE);  

        try {

        FileUtils.copyFile(srcFIle, new File("./ScreenShots/"+nameOfScreenshot));

        } catch (IOException e) {

          e.printStackTrace();

        }
	}
}
