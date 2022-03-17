package com.crm.Organisation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganisationTest
{
	@Test
	public void createOrganizationTest()
	{
		
		//launch browser
	WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");  
		
		//login to application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		//navigate to organisation
		
		driver.findElement(By.linkText("organization")).click();
		//4.click to create organization
		driver.findElement(By.xpath("//img[@alt='Create organization...']")).click();
		//5.
		driver.findElement(By.name("accountname")).sendKeys("ALL STATES");
		//6.save
		driver.findElement(By.xpath("//input[@title='save[Alt+S]']")).click();
		driver.quit();
	}

}
