package com.crm.Contacts;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
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

public class CreateContactlistChooseanyOrg 
{
	@Test
	public void createContactlistChooseanyOrg(CharSequence LastName) throws Throwable, IOException
	{
		
 Random ran = new Random();
 int random = ran.nextInt(500);
		
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
  Sheet sh = wb.getSheet("Org");
  Row ro = sh.getRow(1);
  Cell ce = ro.getCell(2);
  String value = ce.getStringCellValue();
   System.out.println(value);
 /*Step 2: launch the browser*/			 
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
	
  //Step 3: login to application
  driver.findElement(By.name("user_name")).sendKeys(USERNAME);
  driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
  driver.findElement(By.id("submitbutton")).click();
			        
  //Step 4: Navigate to Organizations Link
  driver.findElement(By.linkText("Contacts")).click();
  
  //click on the add org
  driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
  
//adding data to the lastname text field		        
  driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName+" "+random);
  driver.findElement(By.xpath("//img[@title=\"Select\"]")).click();
  ArrayList<String> newTb =new ArrayList<String>(driver.getWindowHandles());
  driver.switchTo().window(newTb.get(1));
  driver.findElement(By.id("4"));
  driver.switchTo().window(newTb.get(0));
  
  //save
  driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click(); 
  
  
	/*logout of application*/
	WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(ele));
	Actions act = new Actions(driver);
	act.moveToElement(ele).perform();
	driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	
	/*close the browser*/
	Thread.sleep(5000);
	driver.quit();
			        
			       
	}

}
