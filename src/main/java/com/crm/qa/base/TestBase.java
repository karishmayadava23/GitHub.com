package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	public static WebDriver driver;// create static webdriver variable
	public static Properties prop;
	public static EventFiringWebDriver event_Driver;
	public static WebEventListener eventListener;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip;

			ip = new FileInputStream("E:/Selenium2018/SeleniumPrograms/FreeCRMTest/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"E:/Selenium2018/setup/set/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "E:/Selenium2018/setup/set/geckodriver-v0.20.0-win64.exe");
			driver = new FirefoxDriver();
		}
		event_Driver= new EventFiringWebDriver(driver);
		//now create object of EventListenerHandler to register it with EventFiringWebDriver 	
		eventListener = new WebEventListener();
		event_Driver.register(eventListener);
		//assign your eventdriver to main driver
		driver=event_Driver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// if we want to change the time then we should include this code in
		// util class
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		// After removing the hard code value
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}
}
