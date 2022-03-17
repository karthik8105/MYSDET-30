package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 
{
	@Test(dataProvider = "getdata")
	public void sampleDataProvider(String Name, String model)
	{
	System.out.println(Name+"------"+model);
	}
	 
	@DataProvider()
	public Object[][] getdata()
	{
	 Object[][] obj = new Object[6][2];
		
	 obj[0][0] = "mi";
	 obj[0][1] = "m13 pro max";

	 obj[1][0] = "vivo";
	 obj[1][1] = "v12"; 
	 
	 obj[2][0] = "iphone";
	 obj[2][1] = "s16";

	 obj[3][0] = "realme";
	 obj[3][1] = "rm13";
	 
	 obj[3][0] = "techno";
	 obj[3][1] = "ts3";
	 
	 obj[3][0] = "honor";
	 obj[3][1] = "ho12";
	 return obj;
		
	}

}
