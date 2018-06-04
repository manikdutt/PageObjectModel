package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName = "Sheet1";
	
	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
        //dealspage = new DealsPage();
        //taskspage = new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		//contactspage = homepage.clickOnContactsLink();
	}
	
	@Test
	public void verifyContactsPageLabel() throws InterruptedException {
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
		boolean cp =  contactspage.verifyContactsLabel();
		Assert.assertTrue(cp);
	}
	
	@Test
	public void verifySelectContactsByName() throws InterruptedException {
        testutil.switchToFrame();
        contactspage = homepage.clickOnContactsLink();
		contactspage.selectContactsByName("A333 A444");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][] = testutil.getTestData(sheetName);
		return data;
	}
	
	@Test(dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company) throws InterruptedException {
        testutil.switchToFrame();
	    contactspage = homepage.clickOnContactsLink();
		homepage.clickOnNewContactLink();
		contactspage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
