package com.airplane;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	boolean isValidUser = Customer2DAO.validateUser(email, password);
    	
    	if (isValidUser)
    	{
    		HttpSession session = request.getSession();
            session.setAttribute("customerId", Customer2DAO.getCustomerByEmailAndPassword(email, password));
            session.setAttribute("customer", Customer2DAO.getCustomerObjectByEmailAndPassword(email, password));
    		response.sendRedirect("dashboard2.jsp");
    	}
    	else
    	{
    		request.setAttribute("errorMessage", "Invalid username or password.");
    		
    		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
    		
    		dispatcher.forward(request, response);
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
