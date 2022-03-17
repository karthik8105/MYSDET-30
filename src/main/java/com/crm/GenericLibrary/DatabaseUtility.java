package com.crm.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains generic method  to read data from database
 * @author prave
 *
 */
public class DatabaseUtility
{
	Connection con = null;
	/**
	 * this method will register the data driver and establish connection with database
	 * @throws Throwable 
	 */
	public void connectToDb() throws Throwable
	{
	Driver driver = new Driver();
    DriverManager.registerDriver(driver);
    con = DriverManager.getConnection(IPathConstant.dbURL, IPathConstant.dbusername, IPathConstant.dbpassword);
    
	}
	/**
	 * this method will used to close the database
	 * @throws Throwable 
	 */
	public void  closeDB() throws Throwable
	{
	con.close();	
	}
	/**
	 * this method is used to  execute query
	 * @throws SQLException 
	 */
	public String executeQueryAndGetData(String Query, int columnIndex,String expdata ) throws SQLException
	{
		String data = null;
		boolean flag =false;
		ResultSet result = con.createStatement().executeQuery(Query);
		while(result.next())
		{
			data = result.getString(columnIndex);
			if(data.equalsIgnoreCase(expdata))
			{
				flag=true;//flag raising
			break;
			}
		}
	if(flag)
	{
		System.out.println(data+"--data verified");
		return expdata;
	}
	else
	{
		System.out.println("data not verified");
		return " ";
	}
	}
	}
