package com.nopCommerceDemo.pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CustomersPage {
	WebDriver driver;

	public CustomersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[contains(@class,'sidebar')]//i[@class='nav-icon far fa-user']//following-sibling::p[contains(.,'Customers')]")
	private WebElement customersMenu;
	
	@FindBy(xpath="//ul[contains(@class,'sidebar')]//p[.=' Customers']")
	private WebElement customersSubMenu;
	
	@FindBy(xpath="//a[contains(.,'Add new')]")
	private WebElement addNew;
	
	@FindBy(xpath="//button[@name='save']")
	private WebElement saveButton;
	
	@FindBy(xpath="//button[@name='save-continue']")
	private WebElement saveAndContinue;
	
	@FindBy(xpath="//div[contains(@class,'danger alert-dismissable')]")
	private WebElement errorMsg;
	
	@FindBy(xpath="//span[.='\'Email\' must not be empty.']")
	private WebElement emailErrorMsg;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath="//input[@id='Gender_Female']")
	private WebElement femaleRadioBtn;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	private WebElement confirmationMsg;
	
	public void clickCustomersMenu()
	{
		addWait(customersMenu);
		customersMenu.click();
	}
	
	public void clickCustomersSubMenu()
	{
		addWait(customersSubMenu);
		customersSubMenu.click();
	}
	
	public void clickAddNew()
	{
		addWait(addNew);
		addNew.click();
	}
	
	public void clickSaveButton()
	{
		saveButton.click();
	}
	
	public void clickSaveAndContinue()
	{
		saveAndContinue.click();
	}
	
	public WebElement viewErrorMsg()
	{
		return errorMsg;
	}
	
	public WebElement viewEmailErrorMsg()
	{
		return emailErrorMsg;
	}
	
	public void setEmailTextBox(String email)
	{
		emailTextBox.sendKeys(email);
	}
	
	public void setPasswordTextBox(String pwd)
	{
		passwordTextBox.sendKeys(pwd);
	}
	
	public void setFname(String fname)
	{
		firstNameTextBox.sendKeys(fname);
	}
	
	public void setLname(String lname)
	{
		lastNameTextBox.sendKeys(lname);
	}
	
	public void setfemaleRadioBtn()
	{
		femaleRadioBtn.click();
	}
	
	public WebElement getConfirmationMsg()
	{
		return confirmationMsg;
	}
	
		
	public void addWait(WebElement element)
	{
		try
		{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Inside WeDriverWait");
		}
		catch(Exception e)
		{
			System.out.println(e.getStackTrace());
		}
	}
	
}
