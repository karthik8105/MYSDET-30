package com.crm.Organisation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Createorgpom 
{
	@Test
	public void createOrganizationTest() throws Throwable
	{
		// launch browser
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
		
		//navigate toorganisationlink
		 HomePage hp = new HomePage( driver);
		 hp.ClickonOrglnk();
		//create org
		 OrganisationPage op = new OrganisationPage(driver);
	      op.clickoncreateorg();
	      
	     //creating org
	     CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	      cop.createNeworg(ORGNAME);
	      
	      //save
	      cop.createsave();
	      //verification
	     OrganisationInfoPage oip = new OrganisationInfoPage(driver);
	      String actOrgName = oip.OrgNameInfo();
	      if(actOrgName.contains(ORGNAME))
	      {
	    	 System.out.println(actOrgName+" data verified");
	      }
	      else
	      {
	    	 System.out.println("data ivalid");
	      }
	      //logout of application
	      hp.signOutofApp(driver);
	      //close the browser
		driver.quit();
	}

}


