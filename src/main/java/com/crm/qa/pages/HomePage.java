package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase{
	
	TestUtil testutil;
	
	@FindBy(xpath="//*[contains(text(),'User: Naveen K')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contact;

	@FindBy(xpath="//td[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath="//td[contains(text(),'Tasks')]")
	WebElement tasks;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserName()
	{
		 boolean username = userNameLabel.isDisplayed();
		 return username;
	}

	public ContactsPage clickOnContactsLink() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(contactsLink));
		Thread.sleep(2000);
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink);
		newContactLink.click();
	}

}
