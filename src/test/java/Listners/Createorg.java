package Listners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;
import com.crm.ObjectRepository.CreateOrganisationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganisationInfoPage;
import com.crm.ObjectRepository.OrganisationPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class Createorg extends BaseClass
{
	@Test
	public void createOrganizationTest() throws Throwable
	{
		String orgName = eLib.readDataFromExcel("Org",1,1);
		String orgNameR = orgName +jLib.getRandomNumber();
		
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
}}
