package com.OrangeHRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.OrangeHRM.Base.OrangeBase;


public class EmployeeList extends OrangeBase{
	
	Actions act = new Actions(driver);
	
	@FindBy (id="menu_pim_viewPimModule") WebElement pim;
	@FindBy (id="menu_pim_addEmployee") WebElement addEmp;
	@FindBy (id="firstName") WebElement firstName;
	@FindBy (id="middleName") WebElement midName;
	@FindBy (id="lastName") WebElement lastName;
	@FindBy (id="employeeId") WebElement id;
	@FindBy (id="photofile") WebElement photo;
	@FindBy (id="chkLogin") WebElement createLogin;
	@FindBy (id="user_name") WebElement userName;
	@FindBy (id="user_password") WebElement userPassword;
	@FindBy (id="re_password") WebElement confirmPassword;
	@FindBy (id="btnSave") WebElement save;
	@FindBy (linkText="") WebElement text;
	
	public EmployeeList()
	{
		PageFactory.initElements(driver, this);
	}

	public void AddEmployees(String fName, String mName, String lName, String ID, String pic, String uName, String pwd, String repwd) throws InterruptedException
	{
		act.moveToElement(pim).build().perform();
		act.moveToElement(addEmp).click().build().perform();
		firstName.sendKeys(fName);
		midName.sendKeys(mName);
		lastName.sendKeys(lName);
		id.sendKeys(ID);
		photo.sendKeys(pic);
		createLogin.click();
		userName.sendKeys(uName);
		userPassword.sendKeys(pwd);
		confirmPassword.sendKeys(repwd);
		save.click();
//		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("btnSave")));
		
	}
	
	public void EmpRepeat(String fName, String mName, String lName, String ID, String pic, String uName, String pwd, String repwd) throws InterruptedException
	{
//		EmployeeList EL = new EmployeeList();
		AddEmployees(fName, mName, lName, ID, pic, uName, pwd, repwd);
	}
}

