package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.WebDriver.*;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Dev\\project\\FreeCRMTest\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			System.out.println("Loaded the prop file");
			prop.load(ip);

		}catch(FileNotFoundException e)
		{

			e.printStackTrace();

		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void initialization() throws InterruptedException
	{
		String BrowserName = prop.getProperty("browser");
		System.out.println("browsername: " + BrowserName);
		if(BrowserName.equals("chrome"))
		{
			// ChromeDriverManager.getInstance().setup();

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dev\\project\\FreeCRMTest\\FreeCRMTest\\src\\main\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(BrowserName.equals("FF"))
		{
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();

			// Tell the Java bindings to use Marionette.
			// This will not be necessary in the future,
			// when Selenium will auto-detect what remote end
			// it is talking to.
			capabilities.setCapability("marionette", true);

			driver = new RemoteWebDriver(capabilities);
			// WebDriver driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
		//driver.manage().window().setSize(new Dimension(1600,900));
	}

}
