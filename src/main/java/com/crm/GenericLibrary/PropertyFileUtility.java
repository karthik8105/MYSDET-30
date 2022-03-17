package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * This class will read data from property file and return  value to user
 * @author karthik
 *
 */
public class PropertyFileUtility
{
/**
 *This method will read data from property file for the key given by the user
 * @param key
 * @return
 * @throws Throwable
 */
public String readDataFromPropertyFile(String key) throws Throwable
{
 FileInputStream fis = new FileInputStream(IPathConstant.Filepath);
 Properties plib = new Properties();
 plib.load(fis);
 String value = plib.getProperty(key);
 return value;
}
}
