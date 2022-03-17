package Listners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.BaseClass;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;

@Listeners(com.crm.GenericLibrary.ITestListnerImplementationClass.class)

public class CreatecontactListners extends BaseClass {
@Test
public void createcontact() throws Throwable

{
	
	String value = eLib.readDataFromExcel("Contacts", 7, 2);
	HomePage hp = new HomePage(driver);
	hp.Clickoncontactlnk();
	
	//click on new contactlink
	ContactsPage cp = new ContactsPage(driver);
	cp.clickonCreateContactimg();
	
	//create contact
	CreateContactPage ccp = new CreateContactPage(driver);
	ccp.createNewContact(value);
	//Assert.fail();
}
}