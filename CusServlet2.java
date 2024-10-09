package com.airplane;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

@WebServlet("/CusServlet2")
public class CusServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public CusServlet2() {
        super();
        
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String name = request.getParameter("name");
    	
    	String username = request.getParameter("username");
    	
    	String email = request.getParameter("email");
    	
    	String contact = request.getParameter("contact");
    	
    	String address = request.getParameter("address");
    	
    	String password = request.getParameter("password");
    	
    	
    	Connection conn = null;
		conn = JDBCConnectivity.Connect();
    	
		
		try
		{
			boolean isRegistered = Customer2DAO.isCustomerRegistered(conn, email, username);
			
			if (isRegistered)
			{
				request.setAttribute("errorMessage", "Customer with this email or username already exists.");
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request,  response);
			}
			else
			{
				Customer2 cus = new Customer2(name, username, email, password, contact, address);
		    	
		    	int customerId = Customer2DAO.InsertCustomer(conn, cus);
		    	
		    	
		    	request.setAttribute("customerId", customerId);
		    	request.setAttribute("customerName", name);
		    	request.setAttribute("customerUsername", username);
		    	
		    	RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
		    	
		    	dispatcher.forward(request, response);
		    	
		    	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				conn.close();
				System.out.println("Connection closed.");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
    	
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
			requestDispatcher.forward(request, response);
			//response.sendRedirect("success.jsp?customerId=" + customerId + "&name=" + name + "&username=" + username);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
		//doGet(request, response);
	}

}
