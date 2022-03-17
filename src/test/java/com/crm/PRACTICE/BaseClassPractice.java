package com.crm.PRACTICE;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClassPractice 
{
@BeforeSuite
public void bsConfig()
{
System.out.println("databaseconnectivity establishment");
}
@BeforeMethod
public void bmConfig()
{
System.out.println("login to app");	
}
@Test
public void actualTest()
{
System.out.println("test script 1");	
}
@AfterMethod
public void  amConfig()
{
System.out.println("log out app");	
}

@AfterClass
public void acConfig()
{
System.out.println("close browser");	
}
@BeforeClass
public void asConfig()
{
System.out.println("close db");	
}
}
