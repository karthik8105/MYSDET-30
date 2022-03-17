package com.crm.Dynamicwedelement;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;

public class ContctLastCheckboxClick extends BaseClass
{
	@Test
	public void lastcontact()
	{
		HomePage hp = new HomePage(driver);
		hp.Clickoncontactlnk();
List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
		
	    ArrayList<WebElement> eles = new ArrayList<WebElement>(ele);
	    
	//    eles.get(eles.size()).click();
	}
	

}
