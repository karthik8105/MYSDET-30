package com.crm.Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpportunitiesContactCampaign 
{
@Test
public void opportunities() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();

	//import all the class
	PropertyFileUtility plib = new PropertyFileUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility jlib = new JavaUtility();

	//READ DATA
	String BROWSER = plib.readDataFromPropertyFile("browser");
	String URL = plib.readDataFromPropertyFile("url");
	String USER = plib.readDataFromPropertyFile("username");
	String PASSWORD = plib.readDataFromPropertyFile("password");
	
	//read org data from excel
 	String orgname = elib.readDataFromExcel("Opportunity", 1, 2)+" "+jlib.getRandomNumber();
 	//read contact name
 	String contactname = elib.readDataFromExcel("Opportunity", 1, 3)+" "+jlib.getRandomNumber();
    //read campaign name
 	String campname = elib.readDataFromExcel("Opportunity", 1, 4)+" "+jlib.getRandomNumber();
 	//read opportunity
 	 String opprortuniyname = elib.readDataFromExcel("Opportunity", 1, 5)+" "+jlib.getRandomNumber();
 	
	//launch browser
	WebDriver driver =null;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		}
	else if(BROWSER.equalsIgnoreCase("firfox"))
	{
		driver = new FirefoxDriver();
	}	
	else
	{
	System.out.println("invalid browser");
	}
	wlib.maximizewindow(driver);
	wlib.waitForPageLoad(driver);
	driver.get(URL);

	//login to application
	driver.findElement(By.name("user_name")).sendKeys(USER);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click(); 	

	//craete organisation
	driver.findElement(By.linkText("Organizations")).click();
	//click to create organization
	driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	//SEND ORG NAME
	driver.findElement(By.name("accountname")).sendKeys(orgname);
	//save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	Thread.sleep(4000);
	
	//create contact
	 driver.findElement(By.linkText("Contacts")).click();
     driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(contactname);  
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//create campaign
     driver.findElement(By.linkText("More")).click();
     driver.findElement(By.linkText("Campaigns")).click();
     driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
     driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(campname);
     driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();;
     
     //opportunity 
	 driver.findElement(By.linkText("Opportunities")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
	 driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys(opprortuniyname);
     driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	// alll =  wlib.switchToWindow(driver, Accounts);
     
	 driver.findElement(By.xpath("//tr[@onmouseout='this.className='lvtColData'']")).click();
}
}
