package com.crm.Contacts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class Createcontactwithmutidatatestng extends BaseClass
{
	//Create Obj for all utilities
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
		
		@Test(dataProvider = "ContactData")
		public void createContactwithmultipledata(String lastName) throws Throwable
		{	
			String lastName2 = lastName+jLib.getRandomNumber();
			//navigate to organization
			HomePage hp = new HomePage(driver);
			hp.Clickoncontactlnk();
			Reporter.log("navigated to cootact link",true);
			
			//create Org
			  ContactsPage cp = new ContactsPage(driver);
			cp.clickonCreateContactimg();
			Reporter.log("click on create contact link",true);
			//create new org
			 CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createNewContact(lastName2);
			Reporter.log("create org with insustry type",true);
			//SAVE
			ccp.getSavebtn();	
			//validate
			 CreateInfoPage cip = new CreateInfoPage(driver);
			String actHeader = cip.contactNameInfo();
			if (actHeader.contains(lastName2)) {
				System.out.println("passed");
			}
			else
			{
				System.out.println("failed");
			}
			Reporter.log("verification successful",true);		
		}
		@DataProvider(name = "ContactData")
		public Object[][] getData() throws Throwable
		{
			Object[][] data = eLib.readmultipleDataFromExcel("contactmultipledata");
			return data;
		}
}
