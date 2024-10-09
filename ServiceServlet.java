package com.airplane;

import java.io.IOException;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	//String customerId = request.getParameter("customerId");
    	
    	System.out.println("Inside Servlet.");
    	
    	String ServiceName = request.getParameter("serviceName");
        String requesterName = request.getParameter("requesterName");
        String contactNumber = request.getParameter("contactNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String dateSlot = request.getParameter("dateSlot");  // Combined date and time
        //String amount = request.getParameter("amount");
        
        

        try {
            // Parse the combined date-time string into LocalDate and LocalTime
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
            LocalDate date = LocalDate.parse(dateSlot, dateTimeFormatter);
            LocalTime time = LocalTime.parse(dateSlot, dateTimeFormatter);
            
            // Validate inputs (basic checks)
            if (requesterName == null || requesterName.isEmpty()) {
                throw new IllegalArgumentException("Requester Name is required.");
            }
            if (contactNumber == null || contactNumber.isEmpty() || !contactNumber.matches("\\d{10}")) {
                throw new IllegalArgumentException("Invalid contact number.");
            }
            if (email == null || email.isEmpty() || !email.contains("@")) {
                throw new IllegalArgumentException("Invalid email.");
            }
            if (address == null || address.isEmpty()) {
                throw new IllegalArgumentException("Address is required.");
            }
          
            
            int customerId = 0;
            
            HttpSession session = request.getSession(false); // false to avoid creating a new session if it doesn't exist
            if (session != null) {
                customerId = (int) session.getAttribute("customerId");
                if (customerId != 0) {
                    // Use customerId as needed
                    System.out.println("Logged in Customer ID: " + customerId);
                } else {
                    // Handle case where customerId is not found in session (e.g., user not logged in)
                    System.out.println("No customerId found in session");
                }
            } else {
                // Handle session being null (e.g., session expired or not logged in)
                System.out.println("Session is not active");
            }

            String customer = Customer2DAO.getCustomerNameById(customerId);
            // Create a new TV_Service object
            Services service = new Services(customerId, ServiceName, requesterName, contactNumber, email, address, date, time);

            // Call the DAO to insert the service
            //ServiceDAO serviceDAO = new ServiceDAO();
            
            Connection conn = null;
            
            conn = JDBCConnectivity.Connect();
            
            
            System.out.println("ABC");
            boolean success = ServiceDAO.insertService(conn, service);

            // Send response based on the result
            if (success) {
            	System.out.println("Redirecting.");
                response.sendRedirect("success1.jsp");  // Redirect to success page
            } else {
                request.setAttribute("errorMessage", "Failed to book service. Please try again.");
                request.getRequestDispatcher("/TVRepair.jsp").forward(request, response);
            }

        } catch (IllegalArgumentException e) {
            // Handle validation errors
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/TVRepair.jsp").forward(request, response);
        } catch (Exception e) {
            // Handle other exceptions
            request.setAttribute("errorMessage", "An error occurred. Please try again.");
            request.getRequestDispatcher("/TVRepair.jsp").forward(request, response);
            e.printStackTrace();
        }
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		service(request, response);
	}

}
