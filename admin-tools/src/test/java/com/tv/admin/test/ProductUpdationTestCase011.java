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
import com.tv.admin.page.ProductPage;
import com.tv.admin.utils.TestUtil;

public class ProductUpdationTestCase011 extends BaseClass {

	public static Logger log = LogManager.getLogger(BaseClass.class.getName());
	LoginPage loginPage;
	ProductPage productPage;
	TestUtil testUtil;
	String sheetName = "Updation";

	public ProductUpdationTestCase011() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		productPage = new ProductPage();
	}

	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 1, dataProvider = "getTestData")
	public void productEdit(String sku, String description) {
		log.info("Starting login test of Application");
		loginPage.validatingLogin(prop.getProperty("username"), prop.getProperty("password"));
		log.info("validation of Admin Account Login is successful");
		log.info("validating Products Link");
		productPage.productsLinks();
		log.info("Products Link Successfully Validated");
		log.info("validating Search Filter");
		productPage.searchFilter(prop.getProperty("title"), prop.getProperty("sku"), prop.getProperty("description"));
		log.info("Search Filter Link Successfully Validated");
		log.info("validating Product Updation");
		productPage.updateProduct(sku, description);
		log.info("Product Updation Successful");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
