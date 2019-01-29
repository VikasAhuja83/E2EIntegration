package org.automation.testingworld.testcases;

import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.datagenerators.SharingSingle_DataGenerator;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.Test;

public class TC_002_Validate_Registration_Functionality extends DriverInstance{
	
	@Test(dataProvider="Excel",dataProviderClass=SharingSingle_DataGenerator.class)
	public void tc_002_register_new_user(String fname,String lname,String mnumber) throws Exception
	{
		LoginPage login = new LoginPage(driver);
		login.enterFirstName(fname);
		login.enterLastName(lname);
		login.enterMobileNumber(mnumber);
	}

}
