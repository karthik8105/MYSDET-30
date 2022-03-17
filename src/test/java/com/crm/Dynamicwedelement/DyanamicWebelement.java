package com.crm.Dynamicwedelement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.HomePage;
//click on contact select all  the contact id
public class DyanamicWebelement extends BaseClass
{
@Test
public void contact() throws Throwable
{
	HomePage hp = new HomePage(driver);
	hp.Clickoncontactlnk();

	List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
for (WebElement wdel : ele) 
{
	wdel.click();
	Thread.sleep(2000);
}

}}
