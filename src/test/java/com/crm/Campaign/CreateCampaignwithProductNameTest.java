package com.crm.Campaign;

import java.io.FileInputStream;
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

public class CreateCampaignwithProductNameTest
{
	@Test
	public void createCampaignwithProductNameTest() throws Throwable
	{
		// read all the data from external files

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

		//navigate to products and create a product 
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(proname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//verification
		String proheader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(proheader.contains(proname))
		{
			System.out.println("product created");
		}else{
			System.out.println("product not created");
		}

		//navigate to Campaign
		
		driver.findElement(By.linkText("More")).click();
		
		driver.findElement(By.name("Campaigns")).click();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		driver.findElement(By.name("campaignname")).sendKeys(comname);

		driver.findElement(By.xpath("//img[@title='Select']")).click();

		Set<String> win = driver.getWindowHandles();
		for(String window : win){
			driver.switchTo().window(window);
		}

		driver.findElement(By.name("search_text")).sendKeys(proname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[.='"+proname+"']")).click();
		
		Set<String> win1 = driver.getWindowHandles();
		for(String window : win1){
			driver.switchTo().window(window);
		}
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


		//verification
		String comheader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(comheader.contains(comname)){
			System.out.println("campaign is created");
		}else{
			System.out.println("campaign is not created");
		}

		// logout to the application
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ele));
		Actions act1 = new Actions(driver);
		act1.moveToElement(ele).perform();

		driver.findElement(By.linkText("Sign Out"));


		// close the application
		driver.close();
		
	}
}

