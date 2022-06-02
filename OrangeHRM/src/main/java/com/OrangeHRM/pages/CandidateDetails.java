package com.OrangeHRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.OrangeHRM.Base.OrangeBase;

public class CandidateDetails extends OrangeBase{

		Actions act;
	
		@FindBy (id="menu_recruitment_viewRecruitmentModule") WebElement recruitmentPage;
		@FindBy (id="menu_recruitment_viewCandidates") WebElement candidatesPages;
		@FindBy (xpath="//*[contains(text(),'Denton')]/ancestor::tr/td/a[text()='Download']") WebElement downloadBtn;
		
		public CandidateDetails() 
		{
			
			PageFactory.initElements(driver, this);
		}
		
		public void CandidateAttachmentDownloads()
		{
			act = new Actions(driver);
			act.moveToElement(recruitmentPage).build().perform();
			act.moveToElement(candidatesPages).click().build().perform();
			downloadBtn.click();
		}
		
		

	

	
}