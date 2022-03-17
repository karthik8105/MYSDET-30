package com.crm.Contacts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AssignOneTest
{
	@Test
	public void assignOne() throws Throwable
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
    Thread.sleep(5000);
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
