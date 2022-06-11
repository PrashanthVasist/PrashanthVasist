package com.tv.admin.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tv.admin.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(id = "admin_user_email")
	WebElement uname;
	@FindBy(id = "admin_user_password")
	WebElement pass;
	@FindBy(name = "commit")
	WebElement submit;
	@FindBy(css = "div[class='flash flash_notice']")
	WebElement flashMessage;
	@FindBy(css = "a[href*='logout']")
	WebElement logoutButton;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void validatingLogin(String username, String password) {
		uname.sendKeys(username);
		pass.sendKeys(password);
		submit.click();
		log.debug("Admin is " + flashMessage.getText());
	}

	public void validatingLogout() {
		logoutButton.click();
	}

}
