package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.Base;

public class LoginPage extends Base {
	
	Actions act = new Actions(driver);
	
	@FindBy(xpath="//input[@placeholder='Email']") WebElement userName;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement password;
	@FindBy(xpath="//div[@class='mt-3 row']/preceding-sibling::button") WebElement lgnBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginValidation(String username, String pwd)
	{   
		
		act.moveToElement(userName).sendKeys(username);
//		userName.sendKeys(username);
		act.moveToElement(password).sendKeys(pwd);
//		password.sendKeys(pwd);
		act.moveToElement(lgnBtn).click();
//		lgnBtn.click();
	}
}
