package com.crm.PRACTICE;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class PracticeTestng 
{
@Test
public void createOrg()
{
	System.out.println("createOrg");
	}
@Test
public void modifyOrg()
{
	System.out.println("modifyOrg");	
	}
@Test
public void deleteOrg()
{
	System.out.println("deleteOrg");	
	Reporter.log("modify log");
	}
}
