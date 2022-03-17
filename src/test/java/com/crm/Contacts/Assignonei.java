package com.crm.Contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class Assignonei
{
@Test
public void assignonei() throws Throwable
{
WebDriverManager.chromedriver().setup();
WebDriverManager.firefoxdriver().setup();

//import all the class
PropertyFileUtility plib = new PropertyFileUtility();
ExcelFileUtility elib = new ExcelFileUtility();
WebDriverUtility wlib = new WebDriverUtility();
JavaUtility jlib = new JavaUtility();

//READ DATA
String BROW = plib.readDataFromPropertyFile("browser");
String URL = plib.readDataFromPropertyFile("url");
String USER = plib.readDataFromPropertyFile("username");
String PASS = plib.readDataFromPropertyFile("password");

//launch browser
WebDriver driver =null;
if(BROW.equalsIgnoreCase("chrome"))
{
	driver = new ChromeDriver();
	}
else if(BROW.equalsIgnoreCase("firfox"))
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
driver.findElement(By.name("user_password")).sendKeys(PASS);
driver.findElement(By.id("submitButton")).click(); 

//click on contact
driver.findElement(By.linkText("Contacts")).click();
//click existig record
driver.findElement(By.linkText("kk")).click();
//click on more information
driver.findElement(By.linkText("More Information")).click();
//click on select Products
driver.findElement(By.xpath("//img[@id='show_Contacts_Products']")).click();
//select the existing Product from Product list page
driver.findElement(By.linkText("new1")).click();
//logout
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
Thread.sleep(1000);
driver.findElement(By.linkText("Sign Out")).click();
}
}
