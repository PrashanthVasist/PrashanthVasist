package com.php.base;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.php.utils.TestUtil;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	public static WebDriver initializeDriver()  {
	
		log.info("Trying to read a configuration and Test is about to Start");
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("File is not found");
		}
		
		log.info("Configuration Read Successfully");
		log.info("Trying to Initialize the Browser");
		
		
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome"))   {
			
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Prashanth\\MyJava\\chromedriver.exe");
			 driver= new ChromeDriver();
			 /*ChromeOptions options =new ChromeOptions();
			 if(browserName.contains("headless"))  {
				 
				 options.addArguments("headless");
				 
				 }
			 driver=new ChromeDriver(options);
			*/
		}
	
	else if (browserName.equals("firefox"))
	{
		 System.setProperty("webdriver.gecko.driver", "C:\\Users\\Prashanth\\MyJava\\geckodriver.exe");
		 driver= new FirefoxDriver();
		
	}
	else if (browserName.equals("IE"))
	{
		 System.setProperty("webdriver.edge.driver", "C:\\Users\\vinay\\Myjava\\msedgedriver.exe");
		 driver= new EdgeDriver();
	}
		
		log.info("Initialization is complete and Browser is up and Running");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		log.info("URL is opened successfully");

		return driver;
		
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
//		TakesScreenshot ts=((TakesScreenshot) driver);
		File source =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/Screenshot/PHPTravels"+testCaseName+TestUtil.getDateTime()+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}
	

}


