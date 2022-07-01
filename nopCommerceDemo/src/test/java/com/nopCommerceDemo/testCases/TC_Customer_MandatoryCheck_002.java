package com.nopCommerceDemo.testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceDemo.pageObject.CustomersPage;
import com.nopCommerceDemo.pageObject.LoginPage;

public class TC_Customer_MandatoryCheck_002 extends BaseClass {
	
	@Test(priority=1)
	public void login()
	{
		LoginPage lp=new LoginPage(driver);
		
		String expectedTitle;
		logger.info("Entering username...");
		lp.setEmail(username);
		logger.info("Entering password...");
		lp.setPwd(password);
		logger.info("Clicking on Login button...");
		lp.clickLogin();
		
		expectedTitle=driver.getTitle();
		
		Assert.assertEquals(expectedTitle,"Dashboard / nopCommerce administration");
		
	}
	
	@Test(priority=2)
	public void customerMandatoryCheck()
	{
		
		CustomersPage cp=new CustomersPage(driver);
		cp.clickCustomersMenu();
		cp.clickCustomersSubMenu();
		cp.clickAddNew();
		cp.clickSaveButton();
		if(cp.viewErrorMsg().isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}


}
