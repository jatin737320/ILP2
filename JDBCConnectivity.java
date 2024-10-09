package com.airplane;

import java.sql.*;

public class JDBCConnectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try
		{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			System.out.println("Driver.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		String URL = "jdbc:derby://localhost:1527/CustomersDatabase;create=true";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("Connection established.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection Connect()
	{
		try
		{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			System.out.println("Driver.");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		String URL = "jdbc:derby://localhost:1527/test;create=true";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(URL);
			System.out.println("Connection established.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}

}
