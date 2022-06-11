package com.tv.admin.test;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tv.admin.base.BaseClass;
import com.tv.admin.page.LoginPage;
import com.tv.admin.page.NewProductPage;
import com.tv.admin.utils.TestUtil;

public class AttributeValidationTestCase003 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	NewProductPage newProductPage;
	TestUtil testUtil;
	String sheetName = "Attribute";

	public AttributeValidationTestCase003() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		newProductPage = new NewProductPage();
	}

	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void attributeValidation(String title, String sku, String description) {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
		log.info("Starting Attribute Validation");
		newProductPage.attributesValidation(title, sku, description);
		log.info("validation of Attribute is successful");
		log.info("Starting Logout Validation");
		loginPage.validatingLogout();
		log.info("Logout validation successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
