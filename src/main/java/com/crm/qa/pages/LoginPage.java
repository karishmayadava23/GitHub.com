package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory -Object Repository
	
	/**@FindBy(name="username")
	WebElement Username11;
	@FindBy(name="password")
	WebElement password11;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpLink;
	@FindBy(xpath="//a[contains(text(),'Log in here')]")
	WebElement logInLink;**/
	@FindBy(xpath="//input[@type='text']")
	WebElement emailAddress;
	@FindBy(xpath="//input[@type='password']")
	WebElement passwordLogin;
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement logInButton;
	
	
	public LoginPage(){
		//Initilizing the Page Objects:
		/**Interview Question-How you will initialise your pagefactory ?
		 * we have one method initElements as below
		 * use to initialise current class objects with driver i.e. this means current class object 
       instead of this we can use LoginPage.class
       so all webelements will be initialised with driver*/
		PageFactory.initElements(driver,this);}
	
	//Actions:
	public String validateLoginTitle(){
		return driver.getTitle();
	}
	public HomePage login(String un,String psw){
		//signUpLink.click();
		//logInLink.click();
		emailAddress.sendKeys(un);
		passwordLogin.sendKeys(psw);
		logInButton.click();
		
		
		/**Username.sendKeys(un);
		password.sendKeys(psw);
		loginButton.click(); **/
		//After clicking on loginbutton user is navigated to homepage so return type of this method is homepage object
		return new HomePage();
	} 	
	
}	

	
	
	
	
	
	
	


