package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsNewPage extends TestBase {

	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstName;
    @FindBy(xpath="//input[@name='middle_name']")
    WebElement middleName;
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	//@FindBy(xpath="//i[@class='unlock icon']")
	//WebElement accessButton;
	@FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/button[2]")
	WebElement saveButton;
	
	LoginPage loginPage;
	FirstPage firstPage;
	HomePage homePage;
	ContactsPage contactsPage;
	ContactsNewPage contactsNewPage;
	public ContactsNewPage(){
		PageFactory.initElements(driver,this);
	}
	public void createNewContact(String ftName,String ltName,String mlName){
		//firstPage.clickOnLogInLink();
		//homePage.clickOnContactsLink();
	//	contactsPage.clickOnNewButton();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		middleName.sendKeys(mlName);
		saveButton.click();
		
		
	
	
		
	}
	
	

}
