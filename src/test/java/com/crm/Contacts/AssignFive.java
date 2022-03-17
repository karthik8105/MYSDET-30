package com.crm.Contacts;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AssignFive
{
@Test
public void assignFive() throws Throwable
{
	//random number
	Random random = new Random();
	int randomnum = random.nextInt(400);

	// read from properties files
 FileInputStream fin = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
 Properties pro = new Properties();
 pro.load(fin);
 String BROWSER = pro.getProperty("browser");
 String URL = pro.getProperty("url");
 String USERNAME = pro.getProperty("username");
 String PASSWORD = pro.getProperty("password");

// read from excel product
FileInputStream finn = new FileInputStream(".\\src\\test\\resources\\Testdata.xlsx");
Workbook wb = WorkbookFactory.create(finn);
Sheet prost = wb.getSheet("Contacts");
Row ro = prost.getRow(7);
Cell cel = ro.getCell(1);
String pronm = cel.getStringCellValue();
System.out.println(pronm);
String proname = pronm+" "+randomnum;

Sheet prost1 = wb.getSheet("Contacts");
Row ro1 = prost1.getRow(7);
Cell cel1 = ro1.getCell(5);
String pronm1 = cel1.getStringCellValue();
//String proname1 = pronm1+" "+randomnum;

Sheet prost2 = wb.getSheet("Contacts");
Row ro2 = prost2.getRow(7);
Cell cel2 = ro2.getCell(4);
    int pronm2 = (int)cel2.getNumericCellValue();
  System.out.println(pronm2);

	//launch browser
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(URL);
	//login to application	
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
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)");
	//click on select Quotes
	driver.findElement(By.xpath("//img[@id='show_Contacts_Quotes']")).click();
	//add quotes
	driver.findElement(By.xpath("//input[@title='Add Quote']")).click();
	//subject name
	driver.findElement(By.xpath("//input[@name='subject']")).sendKeys(pronm);

	
	//ORGANISATION SELECTION
	driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@alt='Select']")).click();
	Set<String> win3 = driver.getWindowHandles();
	for (String windId3 : win3) 
	{
	driver.switchTo().window(windId3);
	}
	driver.manage().window().maximize(); 
	
	driver.findElement(By.linkText("ALL")).click();
/*	Set<String> win4 = driver.getWindowHandles();
	for (String windId4 : win4) 
	{
	driver.switchTo().window(windId4);
	}
	*/
	
	
	Thread.sleep(2000);
	//billing name
	driver.findElement(By.tagName("textarea")).sendKeys(pronm1);
	//shipping name
	driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys(pronm1);
	//scroll down
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,550)");
	Thread.sleep(3000);
	
	//item name
	driver.findElement(By.xpath("//img[@src='themes/images/products.gif']")).click();
    //to handle pop up window
	Set<String> win1 = driver.getWindowHandles();
	for (String windId : win1) 
	{
	driver.switchTo().window(windId);
	}
	driver.manage().window().maximize();
	
	driver.findElement(By.linkText("Lenovo")).click();
	
	
	
	Set<String> win2 = driver.getWindowHandles();
	for (String windId1 : win2) 
	{
	driver.switchTo().window(windId1);
	}
	driver.findElement(By.xpath("//input[@name='qty1']")).sendKeys(String.valueOf(pronm2));
	
	JavascriptExecutor js2 = (JavascriptExecutor) driver;
	js2.executeScript("window.scrollBy(0,600)");
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	JavascriptExecutor js3 = (JavascriptExecutor) driver;
	js3.executeScript("window.scrollBy(0,-600)");
	Thread.sleep(3000);

	
    // driver.quit();
	
}
}
