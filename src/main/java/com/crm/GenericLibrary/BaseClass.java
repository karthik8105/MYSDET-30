package com.crm.GenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	//create objfor all utilities
	public DatabaseUtility dbLib = new DatabaseUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public JavaUtility jLib = new JavaUtility();
	public PropertyFileUtility pLib =new PropertyFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver = null;
	
	public static WebDriver sdriver;
@BeforeSuite(groups ={ "smoke","RegressionSuite"})
	public void connectToDataBase() throws Throwable  
	{
		// dbLib.connectToDb();
		Reporter.log("**db connection successsful**",true);
	}
   @BeforeClass(groups ={ "smoke","RegressionSuite"})
//@Parameters("browser")
//@BeforeTest


public void launchTheBrowser() throws Throwable
    {
    //read data from property file
	String BROWSER = pLib.readDataFromPropertyFile("browser");
	String URL = pLib.readDataFromPropertyFile("url");
//CREATE RUN TIME POLYMORPHISM
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	//	WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if (BROWSER.equalsIgnoreCase("FIREFOX"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid browser");
	}
	
	sdriver=driver;
    wLib.maximizewindow(driver);
    wLib.waitForPageLoad(driver);
    driver.get(URL);
    Reporter.log("***browser launch successfull",true);
    }
@BeforeMethod(groups ={ "smoke","RegressionSuite"})
    public void login() throws Throwable
    {
	String USERNAME = pLib.readDataFromPropertyFile("username");
	String PASSWORD = pLib.readDataFromPropertyFile("password");
	LoginPage lp= new LoginPage(driver);
	lp.loginToApp(USERNAME, PASSWORD);
	Reporter.log("**********login successfull********",true);
    }
@AfterMethod(groups ={ "smoke","RegressionSuite"})
   public void logout()
   {
   driver.quit();
   }
@AfterClass(groups ={ "smoke","RegressionSuite"})
    public void closeBrowser()
    {
   driver.quit();
   Reporter.log("*****browser close successfully*******",true);
   }

@AfterSuite(groups ={ "smoke","RegressionSuite"})
   public void closedb()
   {
   //dbLib.closeDB();
	Reporter.log("=====Database close successdully======",true);
   }
   }
