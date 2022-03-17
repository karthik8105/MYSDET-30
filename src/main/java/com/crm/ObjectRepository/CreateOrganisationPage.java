package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateOrganisationPage extends WebDriverUtility
{
	//step 1 declaration
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="industry")
	private WebElement indusrtydropdown;
	
	@FindBy(name="accounttype")
	private WebElement typedropdown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	//initialization
	public CreateOrganisationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}

	public WebElement getIndusrtydropdown() {
		return indusrtydropdown;
	}

	public WebElement getTypedropdown() {
		return typedropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//business library
	public void createNeworg(String orgName)
	{
	orgnameEdt.sendKeys(orgName);	

	}

	public void createsave()
	{
		saveBtn.click();
	}
	public void dropdownindustry(String orgName,String indtype  )
	{
		orgnameEdt.sendKeys(orgName);
		select(indtype, indusrtydropdown);
		
	}
}