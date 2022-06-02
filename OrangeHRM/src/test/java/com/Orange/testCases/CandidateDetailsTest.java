package com.Orange.testCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.OrangeHRM.Base.OrangeBase;
import com.OrangeHRM.pages.CandidateDetails;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.utils.TestUtils;

public class CandidateDetailsTest extends OrangeBase {

	LoginPage lp;
	CandidateDetails cd;
	TestUtils TestUtil;
	String sheetName = "Login";
	
	public CandidateDetailsTest()
	{
		super();
	}

	@BeforeMethod
	public void Setup() throws IOException
	{
		InitializeDriver();
		lp = new LoginPage();
		cd = new CandidateDetails();
		TestUtil = new TestUtils();
	}
	
	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException
	{
		Object data[][]=TestUtils.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, description="Download CV for Validation", dataProvider = "getTestData")
	public void DownloadCV(String username, String password)
	{
		lp.loginValidation(username, password);
		cd.CandidateAttachmentDownloads();
	}
	
	@AfterMethod
	public void CloseBrowser()
	{
		driver.quit();
	}
}
