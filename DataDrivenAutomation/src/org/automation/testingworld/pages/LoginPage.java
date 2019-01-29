package org.automation.testingworld.pages;

import java.io.IOException;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	//Global WebDriver Object
	WebDriver driver;
	
	public LoginPage(WebDriver driver)//This Constructor Task is to initialize the above mention WebDriver
	{
	 //this.driver is refer to global driver that we define above which we initilaze with local webdriver object 
		this.driver = driver;
	}
	
	public void enterUsername(String uname) throws Exception
	{
		driver.findElement(By.id(Utility.fetchLocatorValues("login_username_id"))).sendKeys(uname);
	}
	
	public void enterPassword(String pass) throws Exception
	{
		driver.findElement(By.id(Utility.fetchLocatorValues("login_password_id"))).sendKeys(pass);
	}
	
	public void enterFirstName(String firstname) throws Exception
	{
		driver.findElement(By.name(Utility.fetchLocatorValues("first_name"))).sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) throws Exception
	{
		driver.findElement(By.name(Utility.fetchLocatorValues("last_name"))).sendKeys(lastname);
	}
	
	public void enterMobileNumber(String mobilenumber) throws Exception
	{
		driver.findElement(By.name(Utility.fetchLocatorValues("mobile_number"))).sendKeys(mobilenumber);
	}
	
	public void clickSignin()throws Exception
	{
		driver.findElement(By.xpath(Utility.fetchLocatorValues("login_signin_xpath"))).click();
	}
}
