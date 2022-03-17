package com.crm.PRACTICE;

import org.testng.annotations.Test;

public class ReadDataFromCmdlineTest
{
@Test
public void readReadDataFromCmdline()
{
  String BROWSER = System.getProperty("browser");
  String URL = System.getProperty("url");
  String USERNAME = System.getProperty("username");
  String PASSWORD = System.getProperty("password");
  
  System.out.println("browser name is "+BROWSER);
  System.out.println("url is "+URL);
  System.out.println("user name is "+USERNAME);
  System.out.println("password name is "+PASSWORD);
}
}