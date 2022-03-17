package com.crm.Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class AssignThree 
{
@Test
public void assignThree() throws Throwable
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
	Row ro = prost.getRow(4);
	Cell cel = ro.getCell(5);
	String pronm = cel.getStringCellValue();
	System.out.println(pronm);
	String proname = pronm+" "+randomnum;
	
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
    Thread.sleep(3000);
    //scroll
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,350)");
	//click on select DOCUMENT
	driver.findElement(By.xpath("//img[@id='show_Contacts_Documents']")).click();
	//add document
	driver.findElement(By.xpath("//input[@title='Add Document']")).click();
	//passing data
	driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(pronm+" "+randomnum);	
	driver.findElement(By.xpath("//input[@name='assigntype']")).click();
	Thread.sleep(2000);
/*
	WebElement aa = driver.findElement(By.xpath("//input[@onclick='toggleAssignType(this.value)'']"));
	Actions act = new Actions(driver);
	act.click(aa);       */
	
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Sign Out")).click();   
    }

}
