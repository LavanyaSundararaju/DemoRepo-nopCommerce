package com.nopCommerceDemo.testCases;

import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.nopCommerceDemo.pageObject.LoginPage;


public class TC_LoginTest_001 extends BaseClass {
	
	
		
	@Test
	public void login()
	{
		LoginPage lp=new LoginPage(driver);
		
		String expectedTitle;
		lp.setEmail(username);
		lp.setPwd(password);
		lp.clickLogin();
		
		expectedTitle=driver.getTitle();
		
		Assert.assertEquals(expectedTitle,"Dashboard / nopCommerce administration");
		
		
	
	}

}
