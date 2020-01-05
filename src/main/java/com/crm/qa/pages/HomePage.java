package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Karishma Yadav')]")
	@CacheLookup 
	WebElement userNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initializing the Page Object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUsername(){
		return userNameLabel.isDisplayed();
		
	}

	public String verifyTitlePage(){
		return driver.getTitle();
		
	}
	
	public  ContactsPage clickOnContactsLink(){
		contactLink.click();
		return new ContactsPage();
		
	}
	public  DealsPage clickOnDealsLink(){
		DealsLink.click();
		return new DealsPage();
		
	}
	public  TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
		
	}
	
	
	
}
