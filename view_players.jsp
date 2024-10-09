<%@ page import = "com.airplane.*" %>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> Customers </h1>
	
	<%
	
	Connection conn = null;
	
	try
	{
		conn = JDBCConnectivity.Connect();
		System.out.println("Connection established.");
	}
	catch(Exception e)
	{
		System.out.println("Error "+e);
	}
	
	ArrayList<Customer2> customers = Customer2DAO.getCustomers(conn);
	
	%>
	
	<table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Username</th>
                <th>Email</th>
                <th>Contact</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <%
            for (Customer2 customer : customers) {
            %>
                <tr>
                    <td><%= customer.getId() %></td>
                    <td><%= customer.getName() %></td>
                    <td><%= customer.getUsername() %></td>
                    <td><%= customer.getEmail() %></td>
                    <td><%= customer.getContact() %></td>
                    <td><%= customer.getAddress() %></td>
                </tr>
            <%
            }
            %>
        </tbody>
    </table>
</body>
</html>