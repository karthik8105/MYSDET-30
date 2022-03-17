package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage
{
//declaration
@FindBy(name="productname")
private WebElement productedtname;

//initialisation
public CreateProductPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}
//utilisation

public WebElement getProductedtname() {
	return productedtname;
}

//business library
public void createNeworg(String orgName)
{
	productedtname.sendKeys(orgName);	

}
}
