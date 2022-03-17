package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ProprtyFilePractice 
{
	@Test
	public void propertyFile() throws Throwable
	{
		//Step 1: read the file
				FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
				
				//Step 2: Create Object of Properties
				Properties pObj = new Properties();
				pObj.load(fis);
				
				//Step 3:read the data
				String URL = pObj.getProperty("username");
				
				//Verification
				System.out.println(URL);
	}

}
