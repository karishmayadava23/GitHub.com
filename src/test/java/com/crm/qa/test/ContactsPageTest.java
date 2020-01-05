package com.crm.qa.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsNewPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.FirstPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	FirstPage firstPage;
 HomePage  homePage;
 TestUtil testUtil;
 ContactsPage contactsPage;
 ContactsNewPage contactsNewPage;
 String sheetName="contacts";
	
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
        contactsPage = new ContactsPage();
      //homePage = new  HomePage();
		 firstPage = new FirstPage();
		 contactsNewPage = new ContactsNewPage();
		
		 loginPage= firstPage.clickOnLogInLink();
		 homePage= loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		 
		 
		 }
/**@throws Exception 
 * @throws InvalidFormatException 
 * @Test
public void verifyContactsLabelNameTest(){
//testUtil.switchToFrame();
contactsPage= homePage.clickOnContactsLink();
Assert.assertTrue(contactsPage.verifyContactsLabelName(),"Contacts Page");
}**/
	
@DataProvider
public Object[][] getCRMTestData() throws InvalidFormatException, Exception{
 Object data[][]=TestUtil.geTestData(sheetName);
 return data;}


	
@Test(dataProvider="getCRMTestData")
public void verifyClickOnNewButtonTest(String firstname,String lastname,String middlename){
	contactsPage= homePage.clickOnContactsLink();
    contactsPage.clickOnNewButton();
  //  contactsNewPage.createNewContact("Taco1","Sai1","Nath1");
    contactsNewPage.createNewContact(firstname, lastname, middlename);
    
    
}

@AfterMethod
public void tearDown(){
	driver.close();
}



}

