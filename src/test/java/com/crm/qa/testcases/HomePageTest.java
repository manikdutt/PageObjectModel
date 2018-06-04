package com.crm.qa.testcases;

import jdk.nashorn.internal.AssertsEnabled;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	DealsPage dealspage;
	TasksPage taskspage;
	TestUtil testutil;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testutil = new TestUtil();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		dealspage = new DealsPage();
		taskspage = new TasksPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyHomePageTitleTest()
	{
		String title = homepage.verifyHomePageTitle();
		String expected = "CRMPRO";
		Assert.assertEquals(title, expected,"Home page title not matched");
	}
	
	@Test
	public void verifyUserNameTest()
	{
		testutil.switchToFrame();
		boolean un = homepage.verifyUserName();
		Assert.assertTrue(un);
	}

	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException {
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
	}
	
	@Test()
	public void clickOnDealsLinkTest()
	{
		testutil.switchToFrame();
		dealspage = homepage.clickOnDealsLink();

	}
	
	@Test
	public void clickOnTasksLink()
	{
		testutil.switchToFrame();
		taskspage = homepage.clickOnTasksLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


	}
	
