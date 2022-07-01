package com.nopCommerceDemo.testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.nopCommerceDemo.utilities.ReadConfig;

public class BaseClass {
	
	WebDriver driver;
	ReadConfig rc=new ReadConfig();
	Logger logger;
	
	String url=rc.getUrl();
	String username=rc.getEmail();
	String password=rc.getPassword();
	
	@BeforeClass
	public void setUp() throws InterruptedException
	{
		logger=Logger.getLogger("nop Commerce Demo");
		PropertyConfigurator.configure("./log4j.properties");
		
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		logger.info("Launching the url");
		driver.get(url);
		Thread.sleep(5000);
		
	}
	
	@AfterClass
	public void tearDown()
	{
		logger.info("Closing the browser");
		driver.quit();
	}
	
	public String randomString()
	{
		String text=RandomStringUtils.randomAlphabetic(5);
		return text;
	}

}
