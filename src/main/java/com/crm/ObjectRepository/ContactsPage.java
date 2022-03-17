package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage
{
	//declaration
@FindBy( xpath = "//img[@alt='Create Contact...']")
private WebElement createcontactlookupimg ;

//initialisation
public ContactsPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
//utilisation
public WebElement getCreatecontactlookupimg() 
{
	return createcontactlookupimg;
}

//business library
public  void clickonCreateContactimg()
{
	createcontactlookupimg.click();
}

}
