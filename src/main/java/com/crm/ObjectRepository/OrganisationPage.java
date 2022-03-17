package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganisationPage extends WebDriverUtility
{
	//1.declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createorgLookup;
	
	//initialisation
	public OrganisationPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}

	//utilisation
	public WebElement getCreateorgLookup() {
		return createorgLookup;
	}
	
	//Business Library
	public void clickoncreateorg()
	{
		createorgLookup.click();
	}
	

}
