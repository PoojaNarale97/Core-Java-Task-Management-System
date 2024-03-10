package com.utilty;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtility {
	
	public static Connection getDBConnection()
	{
		//load Driver
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/TaskManagement","root","root");	
		}
		catch (Exception e) {
			System.out.println("Exception Occured In DB Connection"+e);
		}
		return con;
		
		
	}

}
