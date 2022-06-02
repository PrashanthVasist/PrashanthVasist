package com.php.testCases;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.base.Base;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;
import com.php.pages.ProfileCreation;
import com.php.utils.TestUtil;

public class ProfileCreationExecution extends Base {
	
	HomePage home;
	LoginPage login;
	ProfileCreation profile;
	
	TestUtil testUtil; 
	
	String sheetName = "Profile";
	
	public ProfileCreationExecution ()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup()
	{
		initializeDriver();            
		home = new HomePage();
		login = new LoginPage();
		profile = new ProfileCreation();
		testUtil = new TestUtil();
	}
	
	@DataProvider
	public Object [][] getTestData() throws FileNotFoundException
	{
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test (priority = 2, dataProvider = "getTestData")
	public void profileCreation(String username, String pwd, String fName, String lName, String mob, String mailId, String actCountry, String state, String city, String fax, String zip) throws InterruptedException
	{
		log.info("Validating Login Button");
		home.LoginBtnValidation();					//Methods
		log.info("Login Button validation Completed");
		
		log.info("Validating Login Credentials");
		login.loginValidation(username, pwd);
		log.info("Login Credentials Validation Completed");
		
		log.info("Validating Profile Creation Fields");
		profile.profileValues(fName, lName, mob, mailId, actCountry, state, city, fax, zip);
		log.info("Profile Creation Fields Validated Successfully");
	}

	
	@AfterMethod
	public void quit()
	{
		driver.quit();
	}

}
