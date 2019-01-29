package org.automation.testingworld.testcases;

import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.datagenerators.SharingSingle_DataGenerator;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality_dataproviderinSeperateclass_with_Excel extends DriverInstance {
		
	@Test(dataProvider = "Excel" , dataProviderClass = SharingSingle_DataGenerator.class)
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
