package com.orgill.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgill.base.Base;

public class Test_002_LoginPage extends Base {
	
	@FindBy (xpath="//a[@class='dropdown-toggle']") WebElement signIn;
	@FindBy (id="popUserName") WebElement userName;
	@FindBy (id="popPassword") WebElement pwd;
	@FindBy (xpath="//span[@toggle='#popPassword']/span") WebElement showHideBtn;
	@FindBy (xpath="//button[@class='button pull-right']") WebElement signInBtn;
	
	
	public Test_002_LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void LoginPageValidation(String username, String password)
	{
		signIn.click();
		userName.sendKeys("orgilltestuser19@unilogcorp.com");
		pwd.sendKeys("Test@1234");
		signInBtn.click();
	}
	

}
