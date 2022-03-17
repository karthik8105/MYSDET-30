package com.crm.Contacts;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.JavaUtility;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

public class CreateContactpom 
{
	@Test
	public void createcontact() throws Throwable
	{		
		//read data from property file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		JavaUtility jlib = new JavaUtility();
		
		//read data from excel sheet
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		Row ro = sh.getRow(1);
		Cell ce = ro.getCell(2);
		 String value = ce.getStringCellValue();
		 
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
			
		
			//signout of applicaation
			hp.signOutofApp(driver);
			
			/*Step 8: close the browser*/
			Thread.sleep(5000);
			driver.quit(); 
	        

	}
}
