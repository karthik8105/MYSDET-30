package Listners;

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
import com.crm.ObjectRepository.CreatenewProduct;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductPage;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class CreateCampwtihProductname extends BaseClass
{
	@Test
	public void createCampaignwithProductNamepom() throws Throwable
	{
	
	String PRODUCT = eLib.readDataFromExcel("product",100,1);
	String PRODUCTNAME = PRODUCT + jLib.getRandomNumber();
	
		 HomePage hp = new HomePage(driver);
		hp.Productslink();
		
		ProductPage pp = new ProductPage(driver);
		pp.clickonproduct();
	            CreatenewProduct cnp = new CreatenewProduct(driver);
	            cnp.createNeworg(PRODUCTNAME);
	    //save
	   cnp.save();	
	}}
