package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;

	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		loginpage = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		String expected = "Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(title, expected);
	}

	@Test(priority=2)
	public void loginPageCRMLogoTest()
	{
		boolean flag = loginpage.CRMImage();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public HomePage loginTest() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		return homepage;
	}

	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}



}
