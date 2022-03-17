package com.crm.Organisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisation {
	@Test
	public void createOrganizationTest() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		
		//import read data 
		PropertyFileUtility plib = new PropertyFileUtility();
		ExcelFileUtility elib = new ExcelFileUtility();
		WebDriverUtility wlib = new WebDriverUtility();
	    JavaUtility jlib = new JavaUtility();
	    
		//read data 
		 String BROWSER = plib. readDataFromPropertyFile("browser");
		 String URL = plib. readDataFromPropertyFile("url");
		 String USERNAME = plib. readDataFromPropertyFile("username");
		 String PASSWORD = plib. readDataFromPropertyFile("password");
		   String ORGNAME = elib.readDataFromExcel("Org",4,2)+" "+jlib.getRandomNumber();
		 WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
			driver=new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox"))
			{
			driver=new FirefoxDriver();
			}
			else
			{
			System.out.println("invalid browser");
			}
		  wlib.maximizewindow(driver);
		  wlib.waitForPageLoad(driver);
		   driver.get(URL);  
		//login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//navigate to organisation
		driver.findElement(By.linkText("Organizations")).click();
		//4.click to create organization
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//5.SEND ORG NAME
		driver.findElement(By.name("accountname")).sendKeys(ORGNAME);
		//wlib.getScreenShot(driver, USERNAME);
		//6.save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		wlib.scrollAction(driver);
		driver.quit();
	}

}
