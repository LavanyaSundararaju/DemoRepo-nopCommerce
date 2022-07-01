package com.nopCommerceDemo.testCases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.nopCommerceDemo.pageObject.CustomersPage;
import com.nopCommerceDemo.pageObject.LoginPage;
import com.nopCommerceDemo.pageObject.SearchCustomer;

public class TC_SearchCustomer extends BaseClass{
	
	@Test(priority=2)
	public void searchCustomer()
	{
		SearchCustomer sc=new SearchCustomer(driver);
		CustomersPage cp=new CustomersPage(driver);
		
		cp.clickCustomersMenu();
		cp.clickCustomersSubMenu();
		List<WebElement> al=new ArrayList<WebElement>();
		sc.setEmail("cde@gmail.com");
		sc.clickSearch();
		
		al=sc.getCustomers();
		for(int i=0;i<al.size();i++)
		{
			Reporter.log(al.get(i).getText(), true);
			if(al.get(i).getText().equals("cde@gmail.com"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
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
