package com.crm.Assert;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

public class Createcontact extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable
	{
		String orgName = eLib.readDataFromExcel("Org", 1, 1);
		String orgNameR = orgName+jLib.getRandomNumber();
		 HomePage hp = new HomePage( driver);
		 hp.ClickonOrglnk();
		 String expdata = "Organizations";
		 String actdata = driver.findElement(By.linkText("Organizations")).getText();
		 Assert.assertEquals(actdata, expdata);
		 
		//create org
		 OrganisationPage op = new OrganisationPage(driver);
	      op.clickoncreateorg();
	      String expheader = "Organizations";
			 String actheader = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
			 Assert.assertEquals(actheader, expheader);
	     //creating org
	     CreateOrganisationPage cop = new CreateOrganisationPage(driver);
	      cop.createNeworg(orgNameR);
	      //save
	      cop.createsave();
	      //verification
	     OrganisationInfoPage oip = new OrganisationInfoPage(driver);
	      String actOrgName = oip.OrgNameInfo();
	     Reporter.log(actOrgName+"org created",true);
	}
	
/*	@Test(groups = "smoke")
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
*/
}
