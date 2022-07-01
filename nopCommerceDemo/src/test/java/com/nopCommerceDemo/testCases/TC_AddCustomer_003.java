package com.nopCommerceDemo.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopCommerceDemo.pageObject.CustomersPage;
import com.nopCommerceDemo.pageObject.LoginPage;

public class TC_AddCustomer_003 extends BaseClass {
	
	@Test(priority=2)
	public void addCustomerTest()
	{
		logger.info("Adding customer...");
		String email=randomString();
		CustomersPage cp=new CustomersPage(driver);
		cp.clickCustomersMenu();
		cp.clickCustomersSubMenu();
		cp.clickAddNew();
		cp.setEmailTextBox("cde@gmail.com");
		cp.setPasswordTextBox("1234");
		cp.setFname("xyz");
		cp.setLname("a");
		cp.setfemaleRadioBtn();
		cp.clickSaveButton();
		if(cp.getConfirmationMsg().isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}
	
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

}
