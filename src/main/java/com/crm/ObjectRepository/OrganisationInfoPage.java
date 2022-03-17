package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.GenericLibrary.WebDriverUtility;

public class OrganisationInfoPage extends WebDriverUtility
{
//step1 declaration
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement headerText;

//2.initialisation
public OrganisationInfoPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}

//utilisation
public WebElement getHeaderText() {
	return headerText;
}
//bussiness library
public String OrgNameInfo()
{
  String OrgInfo = headerText.getText();
  return OrgInfo;
}
}
