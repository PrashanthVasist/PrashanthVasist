package com.orgill.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orgill.base.Base;

public class Test_001_ShowHideBtnValidation extends Base {
	
	@FindBy (id="popPassword") WebElement pwd;
	@FindBy (xpath="//span[@toggle='#popPassword']/span") WebElement showHideBtn;
	
	public Test_001_ShowHideBtnValidation()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ShowBtnValidation()
	{
		showHideBtn.click();
		pwd.getAttribute("type");
		
		
	}
}
