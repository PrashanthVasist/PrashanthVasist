package com.Orange.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.OrangeBase;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.utils.TestUtils;

public class LoginPageTest extends OrangeBase{
	
	LoginPage login;
	TestUtils TestUtil;
	String sheetName = "Login";
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws IOException
	{
		InitializeDriver();
		login = new LoginPage();
		TestUtil = new TestUtils();
	}
	
	@DataProvider
	public Object [][] getTestData() throws FileNotFoundException
	{
		Object [][] data = TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1, dataProvider = "getTestData")
	public void loginValidation(String username, String password)
	{
		login.loginValidation(username, password);
	}
	
	@AfterMethod
	public void tearDown() 
	{
		driver.quit();
	}
	
	
}
