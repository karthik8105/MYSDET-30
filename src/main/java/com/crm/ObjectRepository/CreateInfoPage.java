package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateInfoPage 
{
//declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
//initialization
	public CreateInfoPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	//ulilization
	public WebElement getHeaderText() {
		return headerText;
	}
//business library
	public String contactNameInfo()
	{
		String coninfo = headerText.getText();
		return coninfo;
	}

}
