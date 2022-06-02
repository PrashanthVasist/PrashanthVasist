package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class twitterLandingpage {
	
	public WebDriver driver;
	
	private By links=By.tagName("a");
	private By loginButton=By.xpath("//a[@href='/login']");
	private By signupButton=By.cssSelector("a[href*='signup']");
	private  By happinessNow=By.xpath("//main[@role='main']/div/div/div/div[1]/div/div[1]/span");
	private  By joinTwitterToday=By.xpath("//main[@role='main']/div/div/div/div[1]/div/div[2]/span");
	private  By footerLinks=By.cssSelector("nav[role='navigation']");
	
	
	
	
	
	public twitterLandingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		
	}
	
	public WebElement getlinks()
	{
		//driver.findElements(links);
		WebElement l=driver.findElement(links);
		
		return l;
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(loginButton);
	}
	public WebElement getSignupButton()
	{
		return driver.findElement(signupButton);
	}
	
	public WebElement gethappinessNow()
	{
		return driver.findElement(happinessNow);
	}
	
	public WebElement getjoinTwitterToday()
	{
		return driver.findElement(joinTwitterToday);
	}
	
	public WebElement getFooterLinks()
	{

		WebElement footerdriver=driver.findElement(footerLinks);
		List<WebElement> weblinks=footerdriver.findElements(links);
		return footerdriver;
	}
	
	

	
}
