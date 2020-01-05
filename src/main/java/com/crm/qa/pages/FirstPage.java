package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class FirstPage extends TestBase{
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement LogInLink;
	
	public FirstPage(){
		PageFactory.initElements(driver,this);
	}
	
	public LoginPage clickOnLogInLink(){
		LogInLink.click();
		return new LoginPage();
	}

}
