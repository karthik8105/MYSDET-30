package com.crm.GenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author karthik
 *
 */
public class JavaUtility
{
/**
 * This method will return the random number and it will return it to user	
 * @return
 */

	public int getRandomNumber()
	{
		 Random ran = new Random();
		 int random = ran.nextInt(400);
		 return random;		
	}
	/**
	 * This method will generate current system date and return it to user
	 * @return
	 */
public String getSystemDate()
{
   Date d = new Date();
  String date = d.toString();
  return date;
	}
/**
 * This method will generate system date and return date in format
 * @return
 */
public String getSystemDateInFormate()
{
Date d = new Date();
  String d1 = d.toString();
String[] date = d1.split(" ");

String mon = date[1];
String day = date[2];
String time =date[3].replace(":", "-");
String year = date[5];

String DateFormate = day+"-"+mon+"-"+year+"-"+time;
return DateFormate;
}
/**
 * this method for calender mm and yyyy
 * @return
 */
public String getSystemMonthAndYear()
{
	Date d = new Date();
	 String date = d.toString();

   String[] d1 = date.split(" ");
   String mon = d1[1];
   String year = d1[5];
   
  if (mon.contains("Mar"))
  mon="March";
   
   String monthAndYear=mon+" "+year;
   return monthAndYear;
}
/**
 * system date  
 * @return
 */
public String getSystemDay()
{
	Date d= new Date();
	String date = d.toString();
	
	
	 String[] d1 = date.split(" ");
	 String day = d1[2];
	 return day;
}



}
