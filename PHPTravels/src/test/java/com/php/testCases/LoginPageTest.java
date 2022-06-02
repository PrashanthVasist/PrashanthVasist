package com.php.testCases;

import java.io.FileNotFoundException;
import java.security.PublicKey;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.base.Base;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;
import com.php.utils.TestUtil;


public class LoginPageTest extends Base {
	
	HomePage home;    //Global Variable	
	LoginPage login;
	TestUtil testUtil;
	String sheetName = "Login";
	public LoginPageTest() //Constructor
	{
		
		super();
		
	}
	
	@BeforeMethod    //TestNG Annotations
	public void Setup()  //Methods
	{
		initializeDriver();
		home = new HomePage();     //Global variable Object
		login = new LoginPage();
		testUtil = new TestUtil();
		
	}
	
	@DataProvider 
	public Object [][] getTestData() throws FileNotFoundException
	{
		Object [][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 1, dataProvider = "getTestData")
	public void Login(String username, String pwd)   //Main Method 
	{
		log.info("Validating Login Button");
		home.LoginBtnValidation();					//Methods
		log.info("Login Button validation Completed");
		
		log.info("Validating Login Credentials");
		login.loginValidation(username, pwd);
		log.info("Login Credentials Validation Completed");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

	
}
