package com.crm.Dynamicwedelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class PrintlastNameinConsole extends BaseClass
{
	@Test
	public void printlastnameinsonsole()
	{
		HomePage hp = new HomePage(driver);
		hp.Clickoncontactlnk();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvtBg']/tbody/tr[*]/td[1]//a[@title='Contacts']"));
		
for (WebElement wele : ele)
{
	String text = wele.getText();
	System.out.println(text);
	
}
	}

}
