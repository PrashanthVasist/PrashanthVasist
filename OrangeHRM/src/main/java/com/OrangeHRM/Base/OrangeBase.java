package com.OrangeHRM.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.ExtentReporter;
import com.OrangeHRM.utils.TestUtils;

public class OrangeBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static Logger log = LogManager.getLogger(OrangeBase.class.getName());
	
	
	
	public static WebDriver InitializeDriver() throws IOException
	{
		log.info("Initializing WebDriver");
		try {
			prop = new Properties();
			FileInputStream fis;
			fis = new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			log.info("WebDriver file is not found");
//			System.out.println("File is not found");
		}
		log.info("WebDriver is now Initialized");
		
		String BrowserName = prop.getProperty("Browser");
		
		if (BrowserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", prop.getProperty("ChromePath"));
			driver = new ChromeDriver();
		}
		
		else if (BrowserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", prop.getProperty("FirefoxPath"));
			driver = new FirefoxDriver();
		}
		
		else if (BrowserName.equals("edge"))
		{
			System.setProperty("webdriver.msedge.driver", prop.getProperty("EdgePath"));
			driver = new EdgeDriver();
		}
		
		log.info(BrowserName+" is up and running");
		
		wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
//		TakesScreenshot ts=((TakesScreenshot) driver);
		File source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/Screenshot/OrangeHRM"+testCaseName+TestUtils.getDateTime()+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	
}
