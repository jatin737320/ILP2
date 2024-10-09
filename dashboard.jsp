<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.util.*" %>
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
        <a href="dashboard.jsp">Dashboard</a>
        <a href="VehicleRepair.jsp">Vehicle Repair</a>
        <a href="TVRepair.jsp">TV Repair</a>
        <a href="RefrigeratorRepair.jsp">Fridge Repair</a>
        <a href="WashingMachineRepair.jsp">Washing Machine Repair</a>
        <a href="ProductDrop.jsp">Product Pick/Drop</a>
        <a href="ACRepair.jsp">AC Repair</a>
        <a href="HouseCleaning.jsp">House Cleaning</a>
        <a href="logout.jsp" class="logout">Logout</a>
    </div>

    <header>
        <h1>User Orders Dashboard</h1>
    </header>

    <div class="container">
        <table>
            <thead>
                <tr>
                    <th>User/Customer ID</th>
                    <th>User Name</th>
                    <th>Service ID</th>
                    <th>Date</th>
                    <th>Slot</th>
                    <th>Service</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody id="orderTableBody">
                <%
                	/*
                    List<Map<String, String>> orders = (List<Map<String, String>>) request.getAttribute("orders");
                    if (orders != null) {
                        for (Map<String, String> order : orders) {*/
                        	
                    HttpSession session = request.getSession(false); // false to avoid creating a new session if it doesn't exist
                    if (session != null) {
                         Customer2 customer = (Customer2) session.getAttribute("customer");
                        if (customer != null) {
                                // Use customerId as needed
                            System.out.println("Logged in Customer ID: " + customer.get_id());
                        } else {
                                // Handle case where customerId is not found in session (e.g., user not logged in)
                            System.out.println("No customer found in session");
                       	} 
                    }
                    else {
                            // Handle session being null (e.g., session expired or not logged in)
                        System.out.println("Session is not active");
                    }
                %>
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
                    </tr>
                <%
                        }
                    }
                %>
            </tbody>
        </table>

        <div class="pagination" id="pagination">
            <%
                int rowsPerPage = 5;
                int totalOrders = orders != null ? orders.size() : 0;
                int pageCount = (int) Math.ceil((double) totalOrders / rowsPerPage);
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
