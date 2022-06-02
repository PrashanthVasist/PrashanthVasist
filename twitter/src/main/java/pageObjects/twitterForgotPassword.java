package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterForgotPassword {

	public WebDriver driver;

	private By accountSearch = By.cssSelector("input[type='text']");
	private By Search = By.cssSelector("input[type='submit']");

	public twitterForgotPassword(WebDriver driver) {
		this.driver = driver;

	}

	public WebElement getAccountSearch() {
		return driver.findElement(accountSearch);
	}

	public WebElement getSearch() {
		return driver.findElement(Search);
	}

}
