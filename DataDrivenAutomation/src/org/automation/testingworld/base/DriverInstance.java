package org.automation.testingworld.base;

import org.automation.testingworld.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverInstance {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		//so we have to take object in a String so that why we have used toString() method,
		//so here we are typecasting object to a string by using toString() method
		if(Utility.fetchPropertyValues("browserName").toString().equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		driver = new ChromeDriver();
		}
		
		else if(Utility.fetchPropertyValues("browserName").toString().equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		}
		
		else if(Utility.fetchPropertyValues("browserName").toString().equalsIgnoreCase("ie"))
		{
		System.setProperty("webdriver.ie.driver","./Driver/IEDriverServer.exe");	
		driver = new InternetExplorerDriver();
		}
		
		else
		{
			driver = new ChromeDriver();
		}
		
		driver.get(Utility.fetchPropertyValues("applicationURL").toString());
	}

	@AfterMethod
	public void closeDriverInstance()
	{
		driver.quit();
	}
}
