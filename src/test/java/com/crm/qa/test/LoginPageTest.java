package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**Karry**/
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FirstPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	FirstPage firstPage;
 public LoginPageTest(){
	 //to call super class constructor(TestBase constructor)to initialise your properties by using super key 
	 super();
 }
    @BeforeMethod
	public void setUp(){
		initialization();
		 firstPage = new FirstPage();
		 loginPage = new LoginPage();}
    
    @Test(priority=2)
    public void loginPageTitleTest(){
    	firstPage.clickOnLogInLink();
    	String title = loginPage.validateLoginTitle();
    	Assert.assertEquals(title,"Cogmento CRM"); }

   
    @Test(priority=1)
    public void loginTest(){
    	loginPage=firstPage.clickOnLogInLink();
        homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    
    	
    }
	
    @AfterMethod
    public void tearDown(){
    	driver.close();
    }

}
