package com.nopCommerceDemo.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement password;
	
	@FindBy(xpath="//button[.='Log in']")
	private WebElement login;
	
	public void setEmail(String userName)
	{
		email.clear();
		email.sendKeys(userName);
	}
	public void setPwd(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		login.click();
	}

}
