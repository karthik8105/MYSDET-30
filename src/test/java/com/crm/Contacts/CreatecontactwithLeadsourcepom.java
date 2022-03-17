package com.crm.Contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreatecontactwithLeadsourcepom
{
@Test
	public void createcontactlink(CharSequence Name) throws Throwable
	{		
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		//read data from excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		Row ro = sh.getRow(1);
		Cell ce = ro.getCell(2);
		 String value = ce.getStringCellValue();
		
		 Row ro1 = sh.getRow(7);
		 Cell cell = ro1.getCell(7);
		 String value1 = cell.getStringCellValue();
		 
		 Row ro2 = sh.getRow(8);
		 Cell cel2= ro1.getCell(7);
		 String leadsource = cel2.getStringCellValue();
		 
		 System.out.println(value);
		 
		 WebDriver driver = null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
		{
				driver = new FirefoxDriver();
		}
			else
			{
				System.out.println("invalid browser");
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
			driver.get(URL);
			
			//login to app
			LoginPage lp = new LoginPage(driver);
			lp.loginToApp(USERNAME, PASSWORD);
	        //navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.Clickoncontactlnk();
			
			//click on new contactlink
			ContactsPage cp = new ContactsPage(driver);
			cp.clickonCreateContactimg();
			
			//create contact
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createNewContact(value);
			
			//dropdown select
			ccp.createNewContact(value1, leadsource);
			
			//save
			
			//verification
		  	CreateInfoPage cip = new CreateInfoPage(driver);
		  	
		  	 String contactHeader = cip.contactNameInfo();
		  	if(contactHeader.contains(value))
		  	{
		  		System.out.println(contactHeader + "contactcreated");
		  	}
		  	else
		  	{
		  		System.out.println("contact not created");
		  	}
			//signout of applicaation
			hp.signOutofApp(driver);
			
			/*Step 8: close the browser*/
			Thread.sleep(5000);
			driver.quit(); 
	        

}
}