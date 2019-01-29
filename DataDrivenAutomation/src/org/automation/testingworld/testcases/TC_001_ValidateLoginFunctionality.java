package org.automation.testingworld.testcases;

import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality extends DriverInstance {
	
//	@Test
//	public void tc_001_login_functionality() throws Exception
//	{
//		// Here this driver is coming from DriverInstance class which is the parent of this class
//		// as we are inheriting the parent class
//		LoginPage login = new LoginPage(driver);
//		
//		login.enterUsername("username1");
//		login.enterPassword("pass1");
//		login.clickSignin();
//	}
	//This is returning two dimension array of Object
	//By using dataprovider it will execute or run the testcase three time because we are having three set of data
	//here we are not using the loop
	//we will be using dataprovider in a test case	
	
	@DataProvider(name="Static")
		public static Object[][] testDataGenerator()
		{
			Object[][] data = {{"uname1","pass1"},{"uname2","pass2"},{"uname3","pass3"}};
			return data;
		}
	
		
	@Test(dataProvider = "Static")
	public void tc_001_login_functionality(String uname,String pass) throws Exception
	{
		// Here this driver is coming from DriverInstance class which is the parent of this class
		// as we are inheriting the parent class
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}
	
	

}
