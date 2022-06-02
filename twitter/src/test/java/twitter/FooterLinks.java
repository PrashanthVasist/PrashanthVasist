package twitter;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.twitterLandingpage;
import resources.base;

public class FooterLinks extends base {

	public WebDriver driver;

	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();

	}

	@Test

	public void linkTab() throws IOException, InterruptedException {

		driver.get(prop.getProperty("url"));
		twitterLandingpage tlp = new twitterLandingpage(driver);
		WebElement footerdriver = tlp.getFooterLinks();
		footerdriver.findElements(By.tagName("a")).size();

		for (int i = 1; i < footerdriver.findElements(By.tagName("a")).size(); i++) {
			String clickLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerdriver.findElements(By.tagName("a")).get(i).sendKeys(clickLinkTab);
			Thread.sleep(5000L);
		}
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {

			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}
	}

	@AfterTest
	public void teardown() {

		driver.quit();

	}

}
