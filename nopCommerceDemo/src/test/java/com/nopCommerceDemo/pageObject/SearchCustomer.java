package com.nopCommerceDemo.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomer {
	WebDriver driver;
	
	public SearchCustomer(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='SearchEmail']")
	private WebElement searchEmail;
	
	@FindBy(xpath="//button[contains(.,'Search')]")
	private WebElement searchButton;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//thead//th[.='Email']")
	private WebElement tableColumnHeader;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']//tbody//td[2]")
	private List<WebElement> tableRows;
	
	public void setEmail(String email)
	{
		searchEmail.sendKeys(email);
	}
	
	public void clickSearch()
	{
		searchButton.click();
	}
	
	public List<WebElement> getCustomers()
	{
		return tableRows;
	}
	
	
	

}
