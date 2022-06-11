package com.tv.admin.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tv.admin.base.BaseClass;
import com.tv.admin.page.LoginPage;
import com.tv.admin.page.ProductPage;
import com.tv.admin.utils.TestUtil;

public class LoginPageTestCase001 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	ProductPage productPage;
	TestUtil testUtil;

	public LoginPageTestCase001() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		productPage = new ProductPage();
	}

	@Test(priority = 1)
	public void loginTest() {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
