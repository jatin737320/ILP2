<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.*" %>
<%@ page import = "com.airplane.*" %> 
<%@ page import = "java.sql.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Services APP</title>
    <style>
        body {
            background-image: url("https://5.imimg.com/data5/DZ/WI/LU/SELLER-6814007/repair-maintenance.png");
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        .navbar {
            background-color: #333;
            overflow: hidden;
            padding: 10px 20px;
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        .navbar .brand {
            background-color: #c0c0c0;
            border-radius: 4px;
            padding: 10px 20px;
            color: #333;
            font-size: 17px;
            font-weight: bold;
            text-decoration: none;
        }

        .navbar span {
            float: left;
            display: block;
            color: #007bff;
            text-align: center;
            padding: 14px 20px;
            font-size: 17px;
            font-weight: bold;
            cursor: default;
        }

        .navbar a {
            float: left;
            display: block;
            color: #007bff;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .navbar .logout {
            background-color: #dc3545;
            color: white;
            border: none;
            padding: 14px 20px;
            cursor: pointer;
            font-size: 17px;
            text-decoration: none;
            border-radius: 4px;
            margin-left: auto;
        }

        .navbar .logout:hover {
            background-color: #c82333;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 80%;
            margin: 20px auto;
        }

        h1 {
            text-align: center;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #007bff;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        .pagination {
            display: flex;
            justify-content: center;
            padding: 10px 0;
        }

        .pagination a {
            margin: 0 5px;
            padding: 10px;
            border: 1px solid #ddd;
            color: #007bff;
            text-decoration: none;
        }

        .pagination a.active {
            background-color: #007bff;
            color: white;
            border: 1px solid #007bff;
        }

        .pagination a:hover {
            background-color: #ddd;
        }

        footer {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }
    </style>
</head>
<body>
	
    <!-- Navbar -->
    <div class="navbar">
        <span class="brand">Services App</span>
        <a href="dashboard2.jsp">Dashboard</a>
        <!--<a href="VehicleRepair.jsp">Vehicle Repair</a>-->
        <a href="TVRepair.jsp">TV Repair</a>
        <a href="ReferigeratorService.jsp">Fridge Repair</a>
        <a href="WashingMachineRepair.jsp">Washing Machine Repair</a>
        <!--<a href="ProductDrop.jsp">Product Pick/Drop</a>-->
        <a href="ACService.jsp">AC Repair</a>
        <!--<a href="HouseCleaning.jsp">House Cleaning</a>-->
        <a href="Logout.jsp" class="logout">Logout</a>
    </div>

    <header>
        <h1>User Orders Dashboard</h1>
    </header>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>Service ID</th>
                    <th>Service</th>
                    <th>Requester Name</th>
                    <th>Contact Number</th>
                    <th>Email</th>
                    <th>Address</th>
                    <th>Date</th>
                    <th>Time</th>
                </tr>
            </thead>
            
            <% 
            
            Connection conn = null;
            HttpSession sessions = request.getSession(false);
        	
            ArrayList<Services> services = null;
            if (sessions!=null)
            {
           		Customer2 customer = (Customer2) session.getAttribute("customer");
           		
           		if (customer!=null)
           		{
           			System.out.println("Logged in Customer ID: " + customer.getId());
           			
           			try
           			{
	     				conn = JDBCConnectivity.Connect();
	     				System.out.println("Connected.");
           			}
           			catch(Exception e)
           			{
           				System.out.println("Error: "+e);
           			}
     				
           			services = ServiceDAO.getServices(conn, customer);
           			
           			if (services!=null)
           			{
           				for(Services service: services)
           				{
           				%>
	           				<tr>
	           					<td><%=service.getServiceId() %></td>
	           					<td><%=service.getService() %></td>
	           					<td><%=service.getRequesterName() %></td>
	           					<td><%=service.getContactNumber() %></td>
	           					<td><%=service.getEmail() %></td>
	           					<td><%=service.getAddress() %></td>
	           					<td><%=service.getDate() %></td>
	           					<td><%=service.getTime() %></td>
    	       				</tr>
    	       			<%
    	       			}
           				%>
           			<% 	
           			}
           			
           		}
           		else
           		{
           			System.out.println("Not logged in.");
           		}
            }
           	else
           	{
           		System.out.println("Session not found.");
           	}
           	
         	%>
           
            </tbody>
        </table>

        <div class="pagination">
            <% 
                // Example pagination logic (assuming you have services and page numbers available)
                int rowsPerPage = 5;
                int totalServices = services != null ? services.size() : 0;
                int pageCount = (int) Math.ceil((double) totalServices / rowsPerPage);

                for (int i = 1; i <= pageCount; i++) {
            %>
            <a href="?page=<%= i %>" class="<%= request.getParameter("page") != null && Integer.parseInt(request.getParameter("page")) == i ? "active" : "" %>">
                <%= i %>
            </a>
            <% 
                } 
            %>
        </div>
    </div>

    <footer>
        <p>© 2024 Services APP. All rights reserved.</p>
    </footer>
</body>
</html>
