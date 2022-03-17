package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
//declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath ="//img[@title='Select']")
	private WebElement orgNameLookUpinmg;
	
	@FindBy(name="leadsource")
	private WebElement leadSourcedropDown;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
    private WebElement savebtn;
	
	@FindBy(name ="search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement serachBtn;
	
	//initialisation
	
	public CreateContactPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
//utilisation
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNameLookUpinmg() {
		return orgNameLookUpinmg;
	}

	public WebElement getLeadSourcedropDown() {
		return leadSourcedropDown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSerachBtn() {
		return serachBtn;
	}
//business library
	public void createNewContact(String lastName)
	{
	lastNameEdt.sendKeys(lastName);
	savebtn.click();
	}

	public void createNewContact(String lastName, String leadsource)
	{
		lastNameEdt.sendKeys(lastName);
		select(leadsource, leadSourcedropDown);
		leadSourcedropDown.click();
	}
	public void createNewContact(WebDriver driver ,String lastName ,String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpinmg.click();
		switchToWindow(driver, "accounts");
		searchEdt.sendKeys(orgName);
		serachBtn.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		swithctoFrame(driver, "Contacts");
		savebtn.click();
		driver.quit();
	}
	
	}
	
