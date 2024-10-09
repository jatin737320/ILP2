package com.airplane;

import java.sql.*;

import java.util.*;

public class Customer2DAO {
	
	
	public static ArrayList<Customer2> getCustomers(Connection conn)
	{
		ArrayList<Customer2> customers = new ArrayList<Customer2>();
		
		String sql = "select * from ABC.CUSTOMERS";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Customer2 cus = new Customer2(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
				
				customers.add(cus);
				System.out.println("Added."+customers.size());
			}
		}
		catch(Exception e)
		{
			System.out.println("Error encountered "+e);
		}
		
		return customers;
	}
	
	public static boolean isCustomerRegistered(Connection conn, String email, String username)
	{
		boolean isRegistered = false;
		
		String sql = "SELECT COUNT(*) FROM ABC.CUSTOMERS WHERE email = ? OR username = ?";
		
		try
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			pstmt.setString(2, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next())
			{
				int count = rs.getInt(1);
				
				if (count>0)
				{
					isRegistered = true;
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return isRegistered;
		
	}
	public static int InsertCustomer(Connection conn, Customer2 cus)
	{
		int generatedId = -1;
		try
		{
			String sql = "insert into ABC.CUSTOMERS values(default, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, cus.getName());
			
			pstmt.setString(2, cus.getUsername());
			
			pstmt.setString(3, cus.getEmail());
			
			pstmt.setString(4, cus.getPassword());
			
			pstmt.setString(5, cus.getContact());
			
			pstmt.setString(6, cus.getAddress());
			
			int rowsInserted = pstmt.executeUpdate();
			
			if (rowsInserted>0)
			{
				
				ResultSet generatedKeys = pstmt.getGeneratedKeys();
	            if (generatedKeys.next()) {
	            	System.out.println("Here.");
	                generatedId = generatedKeys.getInt(1); // Get the ID of the newly inserted customer
	            }
			
				System.out.println("Inserted row.");
				System.out.println("Inserted successfully.");
				
				
			}
			else
			{
				System.out.println("No rows inserted.");
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Error encountered"+e);
		}
		
		return generatedId;
	}
	
	protected static boolean validateUser(String email, String password)
	{
		boolean isValid = false;
		
		String sql = "SELECT COUNT(*) FROM ABC.CUSTOMERS WHERE email = ? AND password = ?";
		
		Connection conn = null;
		try
		{
			conn = JDBCConnectivity.Connect();
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isValid = rs.getInt(1) > 0;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error "+e);
		}
		
		return isValid;
	}
	
	public static Customer2 getCustomerObjectByEmailAndPassword(String email, String password) {
	    Customer2 customer = null;

	    try {
	        // DB connection and query logic
	        String query = "SELECT * FROM ABC.CUSTOMERS WHERE email = ? AND password = ?";

	        Connection conn = JDBCConnectivity.Connect();

	        PreparedStatement ps = conn.prepareStatement(query);
	        ps.setString(1, email);
	        ps.setString(2, password);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            // Create a customer object and populate it with the retrieved data
	            int customerId = rs.getInt("id");
	            String customerName = rs.getString("name");
	            String username = rs.getString("username");
	            String customerEmail = rs.getString("email");
	            String customerPassword = rs.getString("password");  // Be careful about returning passwords
	            String contactNumber = rs.getString("contact");
	            String address = rs.getString("address");
	            
	            // Assuming you have a constructor in Customer2 class to set all fields
	            customer = new Customer2(customerId, customerName, username, customerEmail, customerPassword, contactNumber, address);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return customer;
	}
	
	public static String getCustomerNameById(int customerId) {
        String customerName = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            conn = JDBCConnectivity.Connect(); // Assuming you have a DBConnection class for connection pooling
            String sql = "SELECT Requester_Name FROM ABC.CUSTOMERS WHERE customer_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, customerId);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                customerName = rs.getString("Requester_Name");
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customerName;
    }
	
	
	
	public static int getCustomerByEmailAndPassword(String email, String password) {
        Customer2 customer = null;
        
        int customerId = 0;
        // Database logic to fetch customer by email and password
        // Pseudo-code example:
        // SELECT * FROM customers WHERE email = ? AND password = ?
        // If a customer is found, create a Customer object and populate the details
        
        try {
            // DB connection and query logic
            // Assuming conn is the database connection
            String query = "SELECT * FROM ABC.CUSTOMERS WHERE email = ? AND password = ?";
            
            Connection conn = JDBCConnectivity.Connect();
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Create a customer object
            	customerId = rs.getInt("id");
                // Set other fields as needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customerId;
    }
}
