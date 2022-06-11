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

public class BatchActionProductTestCase016 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	ProductPage productPage;
	TestUtil testUtil;
	String sheetName = "Deletion";

	public BatchActionProductTestCase016() {
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
	public void batchAction() throws InterruptedException {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
		log.info("validating Products Link");
		productPage.productsLinks();
		log.info("Products Link Successfully Validated");
		log.info("validating Delete All Product");
		productPage.deleteAllProduct();
		log.info("Delete All Product Validation Successful");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
