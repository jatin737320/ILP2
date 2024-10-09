package com.airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.sql.DriverManager;

import java.util.*;

public class ServiceDAO {

    // SQL query to insert a service into the Services table
    private static final String INSERT_SERVICE_SQL = "INSERT INTO ABC.Services2 VALUES (default, ?, ?, ?, ?, ?, ?, ?, ?)";

    // Method to insert a new TV_Service into the database
    
    public static ArrayList<Services> getServices(Connection conn, Customer2 customer) throws SQLException
    {
    	ArrayList<Services> services = new ArrayList<Services>();
    	
    	String sql = "SELECT * FROM ABC.Services2 WHERE CUSTOMER_ID = ?";
    	
    	PreparedStatement pstmt = conn.prepareStatement(sql);
    	
    	pstmt.setInt(1, customer.getId());
    	
    	ResultSet rs = pstmt.executeQuery();
    	
    	//int serviceId, String service, int customerId, String requesterName, String contactNumber, String email, String address, LocalDate date, LocalTime time
    	while(rs.next())
    	{
    		LocalDate date = rs.getDate(8).toLocalDate();
    		LocalTime time = rs.getTime(9).toLocalTime();
    		
    		Services service = new Services(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), date, time);
    		
    		services.add(service);
    	}
    	
    	return services;
    }
    
    
    public static boolean insertService(Connection conn, Services service) {
        boolean inserted = false;

        System.out.println("Inserting.");
        
        // Use a try-with-resources block to automatically close resources
        try
        {
        	PreparedStatement preparedStatement = conn.prepareStatement(INSERT_SERVICE_SQL);
        	// Set the values for the prepared statement
            //preparedStatement.setInt(1, service.getServiceId());
        	preparedStatement.setString(1, service.getService());
            preparedStatement.setInt(2, service.getCustomerId());
            preparedStatement.setString(3, service.getRequesterName());
            preparedStatement.setString(4, service.getContactNumber());
            preparedStatement.setString(5, service.getEmail());
            preparedStatement.setString(6, service.getAddress());
            
            // Format date and time to SQL standard (yyyy-mm-dd for date, hh:mm:ss for time)
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

            preparedStatement.setString(7, service.getDate().format(dateFormatter));  // Set formatted date
            preparedStatement.setString(8, service.getTime().format(timeFormatter));  // Set formatted time
            
            //preparedStatement.setDouble(8, service.getAmount());

            // Execute the update
            int rowsAffected = preparedStatement.executeUpdate();
            
            System.out.println(rowsAffected);
            // Check if the service was successfully inserted
            if (rowsAffected > 0) {
            	System.out.println("Inserted.");
                inserted = true;
            }

        } catch (SQLException e) {
            // Handle SQL exception (log or print stack trace)
            System.out.println("SQL Exception occurred while inserting service: " + e.getMessage());
            e.printStackTrace();
        }

        return inserted;
    }
}
