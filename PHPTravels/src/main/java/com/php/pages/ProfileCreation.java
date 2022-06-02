package com.php.pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.php.base.Base;

public class ProfileCreation extends Base {
	
	Actions act = new Actions(driver);
	
	@FindBy(xpath="//ul[contains(@class,'sidebar-menu')]/li/a[text()=' My Profile']") WebElement myProfile;
	@FindBy(xpath="//input[@name='firstname']") WebElement firstNameField;
	@FindBy(xpath="//input[@name='lastname']") WebElement lastNameField;
	@FindBy(xpath="//input[@name='phone']") WebElement phoneField;
	@FindBy(xpath="//input[@name='email']") WebElement eMailField;
	@FindBy(id="from_country") WebElement countries;
	
	@FindBy(xpath="//span[@class='select2-selection select2-selection--single']") WebElement countryClick;
	@FindBy(xpath="//input[@type='search']") WebElement search;
	@FindBys(@FindBy(xpath="//ul[@id='select2-from_country-results']/li")) List <WebElement> countryList;
	@FindBy(xpath="//input[@name='state']") WebElement stateFieldField;
	@FindBy(xpath="//input[@name='city']") WebElement cityField;
	@FindBy(xpath="//input[@name='fax']") WebElement faxField;
	@FindBy(xpath="//input[@name='zip']") WebElement postZipField;
	
	
	public ProfileCreation ()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void profileValues(String fName, String lName, String mob, String mailId, String actCountry, String state, String city, String fax, String zip) throws InterruptedException
	{
		
		myProfile.click();
		firstNameField.clear();
		firstNameField.sendKeys(fName);
		lastNameField.clear();
		lastNameField.sendKeys(lName);
		phoneField.clear();
		phoneField.sendKeys(mob);
		eMailField.clear();
		eMailField.sendKeys(mailId);
//		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy (0, 500)");
		
		Select s = new Select(countries);
		s.selectByVisibleText(actCountry);
		
//		
//		js.executeScript("arguments[0].click();", countryClick);
//		search.sendKeys(actCountry);
//		
//		for (int i=0;i<countryList.size();i++)
//		{
//			System.out.println(countryList.get(i).getText());
//			if (countryList.get(i).getText().equals(actCountry))
//			{
//				
//				countryList.get(i).click();
//				break;
//			}
//		}
		stateFieldField.sendKeys(state);
		cityField.sendKeys(city);
		faxField.sendKeys(fax);
		postZipField.sendKeys(zip);
		
	}
	
	
}
