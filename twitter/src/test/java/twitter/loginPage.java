package twitter;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.twitterForgotPassword;
import pageObjects.twitterLandingpage;
import pageObjects.twitterLoginPage;
import resources.base;

public class loginPage extends base{
	public WebDriver driver;
	
	 public static Logger log =LogManager.getLogger(base.class.getName());
@BeforeTest

public void initialize() throws IOException
{
	
	 driver =initializeDriver();
		
	
}
	
	@Test(dataProvider="getData")
	
	public void validateLoginPage(String Username, String Password, String text) throws IOException
	{

		driver.get(prop.getProperty("url"));
		twitterLandingpage tlp=new twitterLandingpage(driver);
		tlp.getLoginButton().click();
		twitterLoginPage lp=new twitterLoginPage(driver);
		lp.getEmail().sendKeys(Username);
		lp.getPassword().sendKeys(Password);
		log.info(text);
		lp.getLogin().click();
		System.out.println(lp.getErrorMessage().getText());
		twitterForgotPassword tfp=lp.getforgotPassword();
		tfp.getAccountSearch().sendKeys("sadkjasf");
		tfp.getSearch().click();
	
		
		}
	
	@AfterTest
	public void teardown()
	{
		
		driver.close();
	
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run
		//coloumn stands for how many values per each test
		
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[0][2]="Restrcited User";
		//1st row
		data[1][0]="restricteduser@qw.com";
		data[1][1]="456788";
		data[1][2]= "Non restricted user";
		
		return data;
		
		
		
		
		
		
	}

	
}
