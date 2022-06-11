package com.tv.admin.test;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tv.admin.base.BaseClass;
import com.tv.admin.page.FilterPage;
import com.tv.admin.page.LoginPage;
import com.tv.admin.utils.TestUtil;

public class ProductNotFoundTestCase014 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	FilterPage filterPage;
	TestUtil testUtil;
	String sheetName = "ProductNotFound";

	public ProductNotFoundTestCase014() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		filterPage = new FilterPage();
	}

	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void productNotFoundValidation(String dropdown, String description) {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
		log.info("Starting Product Not Found Filter Validation");
		filterPage.productNotFound(dropdown, description);
		log.info("validation of Product Not Found Filter is successful");
		log.info("Starting Logout Validation");
		loginPage.validatingLogout();
		log.info("Logout validation successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
