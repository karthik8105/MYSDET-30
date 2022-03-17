package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;
import com.crm.GenericLibrary.JavaUtility;
import com.crm.GenericLibrary.PropertyFileUtility;

public class PracticeForGenericUtils
{
@Test
public void practiceGenericUtils() throws Throwable
{
JavaUtility jlib = new JavaUtility();	
int ranNum = jlib.getRandomNumber();
String sysdate = jlib.getSystemDate();
 String sysdateformate = jlib.getSystemDateInFormate();
 System.out.println(ranNum);
 System.out.println(sysdate);
 System.out.println(sysdateformate);
 
PropertyFileUtility proplib = new PropertyFileUtility();
String browsername = proplib.readDataFromPropertyFile("browser");
System.out.println(browsername);

//read data int excel sheet 
ExcelFileUtility elib = new ExcelFileUtility();
String val = elib.readDataFromExcel("contacts", 7, 5);
System.out.println(val);

//write data into excel
//ExcelFileUtility elibb = new ExcelFileUtility();
 elib.writedataintoExcelsheet("Contacts", 7, 8,"karthik");


	}

}
