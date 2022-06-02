package com.php.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.php.base.Base;

public class HomePage extends Base {

	@FindBy(xpath="//div[contains(@class,'header-right d')]/a[text()='Login']") WebElement LoginButton;
	
		
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void LoginBtnValidation()
	{
		LoginButton.click();
	}


}
