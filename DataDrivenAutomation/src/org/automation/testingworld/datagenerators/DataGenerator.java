package org.automation.testingworld.datagenerators;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	
	@DataProvider(name="Excel")
	public static Object[][] testDataGenerator() throws Exception
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

	@DataProvider(name="Register")
	public static Object[][] testDataGeneratorRegister() throws Exception
	{
		FileInputStream file = new FileInputStream("./TestData/TestData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet loginsheet = workbook.getSheet("Register");
		int numberofRows = loginsheet.getPhysicalNumberOfRows();
		//int numberofColumns 
		Object[][] testdata = new Object[numberofRows][3];
		
		for(int i=0;i<numberofRows;i++)
		{
			XSSFRow row = loginsheet.getRow(i);
			XSSFCell firstname = row.getCell(0);
			XSSFCell lastname = row.getCell(1);
			XSSFCell mobilenumber = row.getCell(2);
			testdata[i][0] = firstname.getStringCellValue();
			testdata[i][1] = lastname.getStringCellValue();
			testdata[i][2] = mobilenumber.getStringCellValue();
			
			//return testdata;
		}
		return testdata;

	}

	
}
