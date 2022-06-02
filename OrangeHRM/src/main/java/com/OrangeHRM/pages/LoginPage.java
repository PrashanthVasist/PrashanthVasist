package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Base.OrangeBase;

public class LoginPage extends OrangeBase{
	
	@FindBy(id="txtUsername") WebElement Username;
	@FindBy(id="txtPassword") WebElement Password;
	@FindBy(id="btnLogin") WebElement LoginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void loginValidation(String username, String password)
	{
		Username.sendKeys(username);
		Password.sendKeys(password);
		LoginBtn.click();
	}

}
