package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteUpdate
{
	@Test
	public void sampleJDBCExecuteUpdate() throws Throwable
	{
		Connection con=null;	
		try
		{
		//step1:register the database
		Driver driverRef= new Driver();
		 DriverManager.registerDriver(driverRef);
		 //step2:get onnection to the database
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root", "root");
		 //step3issue create statement
		 Statement state = con.createStatement();
		 //step4:execute aquery
		  int result=state.executeUpdate("insert into student values('4','Shashi','Male');");//insert into table
		if(result==1)
		{
			System.out.println("data is addded successfully");
		}
		else
		{
			System.out.println("data is not addded ");
		}
		}
		catch(Exception e)
		{
	//to handle exception
		}
		
		finally
		{
			//step5:close the database
		con.close();
		}
	}

	
}
