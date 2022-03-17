package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
//1. declaration -use@FindBy annotation
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id ="submitButton")
	private WebElement submitBtn;
	
//2.initialization-use constructor
	public LoginPage(WebDriver  driver)
	{
	PageFactory.initElements(driver, this);
	}

	//3.utilization-providegetters
	public WebElement getUsernameEdt()
	{
		return usernameEdt;
	}

	public WebElement getPasswordEdt() 
	{
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	//business library
	public void loginToApp(String userName,String password )
	{
		usernameEdt.sendKeys(userName);	
		passwordEdt.sendKeys(password);
		submitBtn.click();	
	}}
