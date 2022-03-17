package com.crm.PRACTICE;

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
import org.testng.annotations.Test;

public class DummyTest 
{
@Test
public void dummy() throws Throwable
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
			Sheet prost = wb.getSheet("product");
			Row ro = prost.getRow(1);
			Cell cel = ro.getCell(1);
			String pronm = cel.getStringCellValue();
			System.out.println(pronm);
			String proname = pronm+" "+randomnum;
			
		// read from excel campaign
			
			Sheet comst = wb.getSheet("campaign");
			Row ro1 = prost.getRow(1);
			Cell cel1 = ro.getCell(1);
			String comnm = cel.getStringCellValue();
			String comname = comnm+""+randomnum;          

			//launch the browser
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver= new ChromeDriver();
			}else if(BROWSER.equalsIgnoreCase("firefox"))
			{
				driver=new FirefoxDriver();
			}else{
				System.out.println("invaild browser");
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(URL);

			// step 2 login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
			Thread.sleep(9000);
			
			//scroll
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)");
			
			driver.findElement(By.xpath("//img[@id='show_Contacts_Documents']")).click();
	}
}
