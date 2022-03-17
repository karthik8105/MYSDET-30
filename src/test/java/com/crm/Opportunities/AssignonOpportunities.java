package com.crm.Opportunities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;
import com.crm.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignonOpportunities 
{
@Test
public void assignonOppotunities() throws Throwable
{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();

	//import all the class
	PropertyFileUtility plib = new PropertyFileUtility();
	ExcelFileUtility elib = new ExcelFileUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility jlib = new JavaUtility();

	//READ DATA
	String BROWSER = plib.readDataFromPropertyFile("browser");
	String URL = plib.readDataFromPropertyFile("url");
	String USER = plib.readDataFromPropertyFile("username");
	String PASSWORD = plib.readDataFromPropertyFile("password");
	
	 	//read contact name
	 	String contactname = elib.readDataFromExcel("Opportunity", 1, 3)+" "+jlib.getRandomNumber();
	    //read campaign name
	 	String campname = elib.readDataFromExcel("Opportunity", 1, 4)+" "+jlib.getRandomNumber();
	 	//read opportunity
	 	 String opprortuniyname = elib.readDataFromExcel("Opportunity", 1, 5)+" "+jlib.getRandomNumber();
        // read xepdate
	 	String expdate = elib.readDataFromExcel("Opportunity", 1, 6)+" "+jlib.getRandomNumber();
	 	//launch browser
	 	WebDriver driver =null;
	 	if(BROWSER.equalsIgnoreCase("chrome"))
	 	{
	 		driver = new ChromeDriver();
	 		}
	 	else if(BROWSER.equalsIgnoreCase("firfox"))
	 	{
	 		driver = new FirefoxDriver();
	 	}	
	 	else
	 	{
	 	System.out.println("invalid browser");
	 	}
	 	wlib.maximizewindow(driver);
	 	wlib.waitForPageLoad(driver);
	 	driver.get(URL);

	 	//login to application
	 	driver.findElement(By.name("user_name")).sendKeys(USER);
	 	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 	driver.findElement(By.id("submitButton")).click();
	 	
	 	/*create a contact */

		// navigate to the create link
		driver.findElement(By.linkText("Contacts")).click();

		//click on create new contact button
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		//enter all mandatory fields and click on save
		driver.findElement(By.name("lastname")).sendKeys(contactname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 // verification for contacts
	 		String vercontacts = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
	 		if(vercontacts.contains(contactname))
	 		{
	 			System.out.println("contacts is created");
	 		}else
	 		{
	 			System.out.println("contacts is not created");
	 		}
	 		
	 		/*create a campaign*/
			// navigate to campaign 
			driver.findElement(By.linkText("More")).click();
			driver.findElement(By.linkText("Campaigns")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

			// enter all the mandatory field
			driver.findElement(By.name("campaignname")).sendKeys(campname);
			driver.findElement(By.id("jscal_field_closingdate")).sendKeys(expdate);

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]' and @type='submit']")).click();

			// verification for campaign
			String vercampaign = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			if(vercampaign.contains(campname))
			{
				System.out.println("campaign is created");
			}else{
				System.out.println("campaign is not created");
			}

			/*create opportunities */

			// click on opportunities link
			driver.findElement(By.linkText("Opportunities")).click();

			//click on create new opportunities button
			driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();

			// enter the value for required fields
			driver.findElement(By.name("potentialname")).sendKeys(opprortuniyname);


			// select contact
			driver.findElement(By.xpath("//img[@src='themes/softed/images/select.gif']")).click();
             wlib.switchToWindow(driver, "Accounts");
             driver.findElement(By.partialLinkText("mystate")).click();
             wlib.switchToWindow(driver, "Potentials");
          
             //select lead
             WebElement lead = driver.findElement(By.name("leadsource"));
             Select sel = new Select(lead);
			sel.selectByValue("Employee");
		//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
}
}
