package com.orgill.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	
	public static WebDriver InitializeDriver() throws IOException
	{
		try {
			prop = new Properties();
			fis = new FileInputStream(System.getProperty("user.dir"+"/config/config.properties"));
			prop.load(fis);
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			
		}
		
		String browsername=prop.getProperty("browser");
		
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Java\\Eclipse\\Testing\\Orgill\\config\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if (browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\Java\\Eclipse\\Testing\\Orgill\\config\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get(prop.getProperty("url"));
		driver.findElement(By.id("popPassword")).getAttribute("Type");
		return driver;
	}
	
	
	
	

}
