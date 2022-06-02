package com.orgill.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.orgill.base.Base;

public class LoginPage extends Base {
	
	@FindBy (xpath="//a[@class='dropdown-toggle']") WebElement signIn;
	@FindBy (id="popUserName") WebElement userName;
	@FindBy (id="")

}
