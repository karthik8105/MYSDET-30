package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
@FindBy(linkText="Organizations")
private WebElement organisationlink;

@FindBy(linkText="Contacts")
private WebElement Contactslink;
	
@FindBy(linkText="Opportunities")
private WebElement Opportunitieslink;

@FindBy(linkText="Products")
private WebElement Productslink;

@FindBy(linkText="More")
private WebElement Morelink;

@FindBy(linkText="Campaigns")
private WebElement Campaignslink;


@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratoimg;

@FindBy(linkText="Sign Out")
private WebElement SignOutlink;


//2.initialisation-

public HomePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);	
}


public WebElement getOrganisationlink() {
	return organisationlink;
}


public WebElement getContactslink() {
	return Contactslink;
}


public WebElement getOpportunitieslink() {
	return Opportunitieslink;
}


public WebElement getProductslink() {
	return Productslink;
}


public WebElement getMorelink() {
	return Morelink;
}


public WebElement getCampaignslink() {
	return Campaignslink;
}


public WebElement getAdministratoimg() {
	return administratoimg;
}


public WebElement getSignOutlink() {
	return SignOutlink;
}

//businesss Library

public void ClickonOrglnk()
{
	organisationlink.click();
}

public void Clickoncontactlnk()
{
	Contactslink.click();
}

public void Clickonopportunitylnk()
{
	Opportunitieslink.click();
}

public void Productslink()
{
	Productslink.click();
}
public void signOutofApp(WebDriver driver)
{
mouseHover(driver, administratoimg);	
SignOutlink.click();
}
}
