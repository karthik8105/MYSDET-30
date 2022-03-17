package com.crm.Organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CreateOrgwithmiltipleData2 {
	//Create Obj for all utilities
	PropertyFileUtility pLib = new PropertyFileUtility();
	ExcelFileUtility eLib = new ExcelFileUtility();
	WebDriverUtility wLib = new WebDriverUtility();
	JavaUtility jLib = new JavaUtility();
	
	@Test(dataProvider = "OrgtestData")
	public void createOrgData(String orgName) throws Throwable
	{
		//read data 
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");	
		String orgname = orgName+jLib.getRandomNumber();
		//launch the application
		WebDriver driver = null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("FIREFOX"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		wLib.maximizewindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		//login to application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		Reporter.log("login successful",true);
		//navigate to organization
		HomePage hp = new HomePage(driver);
		hp.ClickonOrglnk();
		Reporter.log("navigated to org link",true);
		
		//create Org
		 OrganisationPage op = new OrganisationPage(driver);
		op.clickoncreateorg();
		Reporter.log("click on create org link",true);
		
		//create new org
		 CreateOrganisationPage cop = new CreateOrganisationPage(driver);
		cop.createNeworg(orgname);
Reporter.log("create org ",true);		
//SAVE
cop.createsave();
//validate
OrganisationInfoPage oip = new OrganisationInfoPage(driver);
String actHeader = oip.OrgNameInfo();
if (actHeader.contains(orgname)) {
System.out.println("passed");
}
else
{
System.out.println("failed");
		}
		Reporter.log("verification successful",true);		
		
		//logout
		hp.signOutofApp(driver);
		
		driver.quit();
	}
	
	@DataProvider(name = "OrgtestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("orgmultiple");
		return data;
	}

}
