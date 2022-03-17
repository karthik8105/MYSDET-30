package com.crm.Contacts;

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


public class AssignTwoi 
{
@Test
public void assigntwo() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
//import data
	PropertyFileUtility plib = new PropertyFileUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	JavaUtility jlib = new JavaUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	
	//read data from property file
	String BROWSER = plib.readDataFromPropertyFile("browser");
	String URL = plib.readDataFromPropertyFile("url");
	String USERNAME = plib.readDataFromPropertyFile("username");
	String PASSWORD = plib.readDataFromPropertyFile("password");
	
	//read read from xl
	String tlilename = elib.readDataFromExcel("Contacts", 4, 4);
	//BROWSER LAUNCH
	WebDriver driver = null;
if(BROWSER.equalsIgnoreCase("chrome"))
{
	driver = new ChromeDriver();
}
else if (BROWSER.equalsIgnoreCase("firefox"))
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

driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click(); 
//click on contact
driver.findElement(By.linkText("Contacts")).click();
//click existig record
driver.findElement(By.linkText("kk")).click();
//click on more information
driver.findElement(By.linkText("More Information")).click();
//scroll
wlib.scrollAction(driver);
driver.findElement(By.xpath("//img[@id='show_Contacts_Documents']")).click();
//add document
driver.findElement(By.xpath("//input[@title='Add Document']")).click();
//ad  title
driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(tlilename);
wlib.scrollAction(driver);
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
driver.findElement(By.linkText("Sign Out")).click();
driver.quit();
}
}
