package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterLoginPage {

	public WebDriver driver;

	private By email = By.cssSelector("input[type='text']");
	private By password = By.cssSelector("input[type='password']");
	private By login = By.cssSelector("div[role='button']");
	private By forgotPassword = By.cssSelector("a[href*='begin_password_reset']");
	private By errorMessage = By.cssSelector("a[href*='begin_password_reset']");

	public twitterLoginPage(WebDriver driver) {
		this.driver = driver;

	}

	public twitterForgotPassword getforgotPassword() {
		driver.findElement(forgotPassword).click();
		return new twitterForgotPassword(driver);

	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getErrorMessage() {
		return driver.findElement(errorMessage);
	}

}
