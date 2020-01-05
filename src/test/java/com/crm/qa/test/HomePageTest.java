package com.crm.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FirstPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase {
	LoginPage loginPage;
	FirstPage firstPage;
 HomePage  homePage;
 TestUtil testUtil;
 ContactsPage contactsPage;
	
	public HomePageTest(){
		super();
	}
	//test cases should be seperated --independent with each other
	//before each test case --launch the browser and login
	//after each test cases --close the browser
	//
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
        // loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		
		
		// homePage = new  HomePage();
		 firstPage = new FirstPage();
			loginPage= firstPage.clickOnLogInLink();
			homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 
		}
	
	@Test(priority=2)
	//whenever you write add test word at last so that people know it is testMethod
	public void verifyHomePageTitleTest(){
		
		String homePageTitle= homePage.verifyTitlePage();}
	@Test(priority=1)
	public void verifyCorrectUserNameTest(){
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyUsername());
	}
	@Test(priority=3)
	public void verifyContactLinks(){
		contactsPage= homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		 
		 
		

}
