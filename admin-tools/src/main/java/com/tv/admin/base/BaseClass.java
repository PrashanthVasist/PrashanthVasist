 package com.tv.admin.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.internal.Base64;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tv.admin.utils.TestUtil;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(BaseClass.class.getName());

	public BaseClass() {
		log.info("Trying to read config and test is about to start");
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config/config.properties");

			prop.load(fis);
		} catch (Exception e) {

		}
		log.info("config readed successfully");
	}

	public static WebDriver initialization() {
		log.info("Trying to start initialization of Browser");
		String browserName = prop.getProperty("Browser");
		String os = prop.getProperty("os.name");
		if (os.contains("windows")) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//windowsDrivers//chromedriver.exe");
				driver = new ChromeDriver();
			}

			else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver", ".//windowsDrivers//geckodriver.exe");
				driver = new FirefoxDriver();
			}

			else if (browserName.equals("MicrosoftEdge")) {
				System.setProperty("webdriver.edge.driver", ".//windowsDrivers//msedgedriver.exe");
				driver = new EdgeDriver();

			}
			log.info("initilization is completed and browser is up and running");
		}

		if (os.contains("mac")) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//macDrivers//chromedriver");
				driver = new ChromeDriver();
			} else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver", ".//macDrivers//geckodriver");
				driver = new FirefoxDriver();
			}
		}

		if (os.contains("linux")) {
			if (browserName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//linuxDrivers//chromedriver");
				driver = new ChromeDriver();
			}

			else if (browserName.equals("FireFox")) {
				System.setProperty("webdriver.gecko.driver", ".//linuxDrivers//geckodriver");
				driver = new FirefoxDriver();
			}
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("entered url successfully");
		return driver;
	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Screenshots/admin-tools" + testCaseName
				+ TestUtil.getCurrentDataTime() + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}

	public String getScreenShotPathBase64(String testCaseName, WebDriver driver) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "/Screenshots/admin-tools+" + testCaseName
				+ TestUtil.getCurrentDataTime() + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		byte[] imageBytes = IOUtils.toByteArray(new FileInputStream(destinationFile));
		return Base64.encode(imageBytes);
	}

}
