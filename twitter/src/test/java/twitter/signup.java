package twitter;

import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.twitterLandingpage;
import pageObjects.twitterSignup;
import resources.base;

public class signup extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();
		 log.info("Driver is initialized");
		
			
		
	}
	@Test
	
	public void validateSignup() throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));
		 log.info("Navigated to Home page");
		 twitterLandingpage tlp=new twitterLandingpage(driver);
		 tlp.getSignupButton().click();
		 twitterSignup ts=new twitterSignup(driver);
		 ts.getNameText().sendKeys("hfgjfkk");
		 ts.getchangeToEmail().click();
		 ts.getEmail().sendKeys("use511r@gmail.com");
		 ts.getMonth().sendKeys("May");
		 ts.getDay().sendKeys("25");
		 ts.getYear().sendKeys("2021");
		 Thread.sleep(5000);
		 ts.getNextButton().click();
		 log.info("clicked step 1 next button");
		 WebDriverWait wait = new WebDriverWait(driver,30);
		 ts.getStep2NextButton().click();
		 log.info("clicked step 2 next button");
		//WebElement object=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='r-1v6e3re']")));
		//object.click();
		 ts.getSignUp().click();
		log.info("clicked signup button");
		System.out.println(ts.getErrorText().getText());
		ts.getClose().click();
		 
		
		}

	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}


	

	
}
