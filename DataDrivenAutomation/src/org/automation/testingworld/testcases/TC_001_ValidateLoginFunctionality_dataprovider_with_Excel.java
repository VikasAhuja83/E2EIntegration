package org.automation.testingworld.testcases;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.automation.testingworld.base.DriverInstance;
import org.automation.testingworld.pages.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_001_ValidateLoginFunctionality_dataprovider_with_Excel extends DriverInstance {
	
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
	
	@Test(dataProvider = "Excel")
	public void tc_001_login_functionality(String uname,String pass) throws Exception
	{
		// Here this driver is coming from DriverInstance class which is the parent of this class
		// as we are inheriting the parent class
		LoginPage login = new LoginPage(driver);
		
		login.enterUsername(uname);
		login.enterPassword(pass);
		login.clickSignin();
	}
	
	
//This is returning two dimension array of Object
//By using dataprovider it will execute or run the testcase three time because we are having three set of data
//here we are not using the loop
//we will be using dataprovider in a test case	
	@DataProvider(name="Excel")
	public Object[][] testDataGenerator() throws Exception
	{
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Login");
		int numberofRows = loginsheet.getPhysicalNumberOfRows();
		//int numberofColumns 
		Object[][] testdata = new Object[numberofRows][2];
		
		for(int i=0;i<numberofRows;i++)
		{
			XSSFRow row = loginsheet.getRow(i);
			XSSFCell username = row.getCell(0);
			XSSFCell password = row.getCell(1);
			
			testdata[i][0] = username.getStringCellValue();
			testdata[i][1] = password.getStringCellValue();
			
			//return testdata;
		}
		return testdata;

	}
	
	
}
