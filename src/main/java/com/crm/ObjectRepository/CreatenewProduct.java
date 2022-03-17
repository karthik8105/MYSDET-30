package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatenewProduct 
{
//declaration
	@FindBy(name="productname")
	private WebElement productEdtName;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//initialization
	public CreatenewProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//utilisation
	public WebElement getProductEdtName() {
		return productEdtName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//business library
	public void createNeworg(String orgName)
	{
		productEdtName.sendKeys(orgName);	

	}
	public void save()
	{
		saveBtn.click();	
	}
	
}
