package com.Orange.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.OrangeBase;
import com.OrangeHRM.pages.EmployeeList;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.utils.TestUtils;

public class EmployeeListTest extends OrangeBase {
	
	LoginPage lpt;
	EmployeeList el;
	String sheetName = "EmployeeList";
	
	public EmployeeListTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		InitializeDriver();
		lpt = new LoginPage();
		el = new EmployeeList();
	}
	
	
	
	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException
	{
		Object [][] data = TestUtils.getTestData(sheetName);
		return data;
	}
	
	
	@Test (priority=1, dataProvider = "getTestData")
	public void AddEmployees(String userName, String password, String fName, String mName, String lName, String ID, String pic, String uName, String pwd, String repwd) throws InterruptedException
	{
		lpt.loginValidation(userName, password);
		el.AddEmployees(fName, mName, lName, ID, pic, uName, pwd, repwd);
//		el.EmpRepeat(fName, mName, lName, ID, pic, uName, pwd, repwd);
	}
	
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
