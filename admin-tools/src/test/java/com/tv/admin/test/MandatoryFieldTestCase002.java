package com.tv.admin.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tv.admin.base.BaseClass;
import com.tv.admin.page.LoginPage;
import com.tv.admin.page.NewProductPage;
import com.tv.admin.utils.TestUtil;

public class MandatoryFieldTestCase002 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	NewProductPage newProductPage;
	TestUtil testUtil;

	public MandatoryFieldTestCase002() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		newProductPage = new NewProductPage();
	}

	@Test(priority = 1)
	public void mandatoryFieldsValidation() {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
		log.info("Starting Mandatory Field of Validation");
		newProductPage.mandatoryFieldsValidation();
		log.info("validation of Mandatory Field is successful");
		log.info("Starting Logout Validation");
		loginPage.validatingLogout();
		log.info("Logout validation successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
