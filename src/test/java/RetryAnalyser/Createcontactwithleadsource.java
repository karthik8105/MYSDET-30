package RetryAnalyser;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateInfoPage;
import com.crm.ObjectRepository.HomePage;
@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)
public class Createcontactwithleadsource extends BaseClass
{
	@Test(retryAnalyzer = com.crm.GenericLibrary.RetryAnalyserImplements.class)
	public void createcontactlink() throws Throwable
	{		
		String lead = eLib.readDataFromExcel("Contacts", 100, 2);	
		  String value = lead+jLib.getRandomNumber();
		  
		  String lead2 = eLib.readDataFromExcel("Contacts", 7, 7);
		  String value1 = lead2+jLib.getRandomNumber();
		  
		  String lead3 = eLib.readDataFromExcel("Contacts", 8, 7);
		  String leadsource = lead3+jLib.getRandomNumber();
		  
	        //navigate to contact link
			HomePage hp = new HomePage(driver);
			hp.Clickoncontactlnk();
			
			//click on new contactlink
			ContactsPage cp = new ContactsPage(driver);
			cp.clickonCreateContactimg();
			
			//create contact
			CreateContactPage ccp = new CreateContactPage(driver);
			ccp.createNewContact(value);
			
			//dropdown select
			ccp.createNewContact(value1, leadsource);
	
			//verification
		  	CreateInfoPage cip = new CreateInfoPage(driver);
		  	
		  	 String contactHeader = cip.contactNameInfo();
		  	if(contactHeader.contains(value))
		  	{
		  		System.out.println(contactHeader + "contactcreated");
		  	}
		  	else
		  	{
		  		System.out.println("contact not created");
		  	}}

}
