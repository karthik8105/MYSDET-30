package com.crm.Organisation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
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

public class CreateOrganisationAssignment 
{
@Test
public void createorganisation(CharSequence OrgName) throws Throwable
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
			Sheet sh = wb.getSheet("Org");
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
				
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		        driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		        driver.findElement(By.id("submitbutton")).click();
			
		//navigate to organisation link
		        driver.findElement(By.linkText("Organizations")).click();
		        
		//click on add new organisato        
		        driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		        
		//click on mandatory 
		        driver.findElement(By.name("accountname"));
		        
		        driver.findElement(By.name("accountname")).sendKeys(OrgName);
		      //click on save
		    	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click(); 
		   
		    	/*Step 7: logout of application*/
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.visibilityOf(ele));
				Actions act = new Actions(driver);
				act.moveToElement(ele).perform();
				driver.findElement(By.xpath("//a[.='Sign Out']")).click();
				
				/*Step 8: close the browser*/
				Thread.sleep(5000);
				driver.quit();
	}

}

