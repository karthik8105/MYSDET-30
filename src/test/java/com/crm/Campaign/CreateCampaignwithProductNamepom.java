package com.crm.Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.CreatenewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignwithProductNamepom 
{
@Test
public void createCampaignwithProductNamepom() throws Throwable
{// launch browser
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
	    LoginPage lp = new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	
	 HomePage hp = new HomePage(driver);
	hp.Productslink();
	
	ProductPage pp = new ProductPage(driver);
	pp.clickonproduct();
            CreatenewProduct cnp = new CreatenewProduct(driver);
            cnp.createNeworg(ORGNAME);
    //save
    cnp.save();
    
   //logout of application
  	    hp.signOutofApp(driver);
  	      //close the browser
  		driver.quit();
			}}
