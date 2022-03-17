package com.crm.Organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateorgwithIndtypeTestng extends BaseClass
{
	@Test
	public void createOrgwithIndustryDropDownpomTestng() throws Throwable
	{
		 String ORGNAME = eLib.readDataFromExcel("Org",4,2)+" "+jLib.getRandomNumber();
		   String dropname = eLib.readDataFromExcel("Org", 4, 3);
	//navigate toorganisationlink
	 HomePage hp = new HomePage( driver);
	 hp.ClickonOrglnk();
	//create org
	 OrganisationPage op = new OrganisationPage(driver);
      op.clickoncreateorg();
      
      
	     //add orgname
	     CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	      cop.createNeworg(ORGNAME);
	      //drop down industry
	      cop.dropdownindustry(ORGNAME, dropname);
	      //save
	      cop.createsave();
	      
	      //verification
	     OrganisationInfoPage oip = new OrganisationInfoPage(driver);
	      String actOrgName = oip.OrgNameInfo();
	      if(actOrgName.contains(ORGNAME))
	      {
	    	 System.out.println(actOrgName+" data verified");
	      }
	      else
	      {
	    	 System.out.println("data ivalid");
	      }

	
	}
}
