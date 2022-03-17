package com.crm.Contacts;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class CreatecontactpomTestng extends BaseClass

{
@Test
public void createcontact() throws Throwable

{
	
	String value = eLib.readDataFromExcel("Org", 1, 1);
	HomePage hp = new HomePage(driver);
	hp.Clickoncontactlnk();
	
	//click on new contactlink
	ContactsPage cp = new ContactsPage(driver);
	cp.clickonCreateContactimg();
	
	//create contact
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.createNewContact(value);	
}
@Test(groups = "smoke")
public void test()
{
	Reporter.log("testing SMOKE2 in CreatecontactpomTestng",true);
	Assert.fail();
}

@Test(groups = "RegressionSuite")
public void testRegrestion()
{
	Reporter.log("testing REGRESSION2 in CreatecontactpomTestng",true);
}

@Test
public void testcontactRegional()
{
	Reporter.log("testing RegionalRegression02 in CreatecontactpomTestng",true);
}
}
