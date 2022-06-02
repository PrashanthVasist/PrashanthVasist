package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterSignup {

	
	public WebDriver driver;
	
	private By name=By.cssSelector("input[type='text']");
	private By changeToEmail=By.cssSelector("div[class*='r-1n1174f']");
	private By email=By.cssSelector("input[name='email']");
	private By month=By.id("SELECTOR_1");
	private By day=By.id("SELECTOR_2");
	private By year=By.id("SELECTOR_3");
	private By nextButton=By.xpath("//div[@role='dialog']/div[2]/div[2]/div");
	private By step2nextButton=By.xpath("//div[@role='dialog']/div[2]/div[2]/div");
	private By signUp=By.cssSelector("div[class*='r-1v6e3re']");
	private By errorText=By.cssSelector("span[class*='r-poiln3'] span");
	private By close=By.cssSelector("div[role='button'] div");
	
	
	public twitterSignup(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}


	public WebElement getNameText()
	{
		return driver.findElement(name);
	}
	
	public WebElement getchangeToEmail()
	{
		return driver.findElement(changeToEmail);
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	public WebElement getMonth()
	{
		return driver.findElement(month);
	}
	
	public WebElement getDay()
	{
		return driver.findElement(day);
	}
	
	public WebElement getYear()
	{
		return driver.findElement(year);
	}
	
	public WebElement getNextButton()
	{
		return driver.findElement(nextButton);
	}
	
	public WebElement getStep2NextButton()
	{
		return driver.findElement(step2nextButton);
	}
	
	public WebElement getSignUp()
	{
		return driver.findElement(signUp);
	}
	
	public WebElement getErrorText()
	{
		return driver.findElement(errorText);
	}
	
	public WebElement getClose()
	{
		return driver.findElement(close);
	}

	
	
}
