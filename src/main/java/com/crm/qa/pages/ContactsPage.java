package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy (xpath="//*[@id='dashboard-toolbar']/div[1]")
	WebElement contactLabelName;
	
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a/button")
	WebElement newButton;
	//*[@id="dashboard-toolbar"]/div[2]/div/a/button
	//*[@id="dashboard-toolbar"]/div[2]/div/button[2]/text()
	//*[@id="dashboard-toolbar"]/div[2]/div/button[1]

	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabelName(){
		return contactLabelName.isDisplayed();
	}
    public void clickOnNewButton(){
    	newButton.click();
    }
    
  


}

//*[@id="dashboard-toolbar"]/div[1]/text()