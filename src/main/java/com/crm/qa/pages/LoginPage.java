package com.crm.qa.pages;

import org.apache.commons.httpclient.methods.ExpectContinueMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath="//*[@type='submit']/parent::div")     //div[@class='input-group-btn']
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUp;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean CRMImage()
	{
		 return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd ) throws InterruptedException {
		username.sendKeys(un);
		password.sendKeys(pwd);

	    WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
		Thread.sleep(2000);
		//JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", loginBtn);
		loginBtn.click();
		return new HomePage();
	}
	
	
}
