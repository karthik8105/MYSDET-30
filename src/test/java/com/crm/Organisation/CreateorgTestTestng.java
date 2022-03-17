package com.crm.Organisation;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;
@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class CreateorgTestTestng extends BaseClass
{
	@Test
	public void createOrganizationTest() throws Throwable
	{
		String orgName = eLib.readDataFromExcel("Org", 1, 1);
		String orgNameR = orgName+jLib.getRandomNumber();
		 HomePage hp = new HomePage( driver);
		 hp.ClickonOrglnk();
		//create org
		 OrganisationPage op = new OrganisationPage(driver);
	      op.clickoncreateorg();
	     //creating org
	     CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	      cop.createNeworg(orgNameR);
	      //save
	      cop.createsave();
	      //verification
	     OrganisationInfoPage oip = new OrganisationInfoPage(driver);
	      String actOrgName = oip.OrgNameInfo();
	      if(actOrgName.contains(orgNameR))
	      {
	    	 System.out.println(actOrgName+" data verified");
	      }
	      else
	      {
	    	 System.out.println("data ivalid");
	      }
	}
	@Test(groups = "smoke")
	public void test()
	{
		Reporter.log("testing SMOKE1 in CreateorgTestTestng",true);
	}
	
	@Test(groups = "RegressionSuite")
	public void testRegrestion()
	{
		Reporter.log("testing REGRESSION1 in CreateorgTestTestng",true);
	}
	
	@Test
	public void testorgRegionalRegression()
	{
		Reporter.log("testing RegionalRegression01 in CreateorgTestTestng",true);
	}
}
