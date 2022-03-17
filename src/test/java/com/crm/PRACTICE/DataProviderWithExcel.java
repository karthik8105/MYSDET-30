package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.GenericLibrary.ExcelFileUtility;

public class DataProviderWithExcel 
{
	@Test(dataProvider = "data")
	public void data(String orgname , String indtype)
	{
		System.out.println(orgname+"  "+indtype );
	}

@DataProvider(name="data")
public Object[][] getData() throws Throwable
{
ExcelFileUtility eLib = new ExcelFileUtility();
Object[][] value =eLib.readmultipleDataFromExcel("practicemultipledata");
return value;
}
}
