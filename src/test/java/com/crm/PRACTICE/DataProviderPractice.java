package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class DataProviderPractice
{
@Test(dataProvider = "getdata")
public void sampleDataProvider(String Name, String model,int qty)
{
System.out.println(Name+"------"+model+"-----"+qty);
}
 
@DataProvider()
public Object[][] getdata()
{
 Object[][] obj = new Object[4][3];
	
 obj[0][0] = "mi";
 obj[0][1] = "m13 pro max";
 obj[0][2] = 25;

 obj[1][0] = "vivo";
 obj[1][1] = "v12";
 obj[1][2] = 20;
 
 obj[2][0] = "iphone";
 obj[2][1] = "s16";
 obj[2][2] = 10;

 obj[3][0] = "realme";
 obj[3][1] = "rm13";
 obj[3][2] = 15;
 
 return obj;
	
}
}
