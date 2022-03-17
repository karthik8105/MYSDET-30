package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage
{
//declaration
	@FindBy(xpath = "//img[@alt='Create Product...']")
	private WebElement createorgLookup;
//initialisation
	public ProductPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
//utilisation
	public WebElement getCreateorgLookup() {
		return createorgLookup;
	}

	//business library
	public void clickonproduct()
	{
		createorgLookup.click();
	}
}
