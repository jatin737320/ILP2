<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="3;url=login.jsp"> <!-- Redirect to dashboard after 3 seconds -->
    <title>Registration Successful</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
        .success-message {
            border: 1px solid #4CAF50;
            color: #4CAF50;
            padding: 20px;
            display: inline-block;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div class="success-message">
        <h1>Registration Successful!</h1>
        <p>Your details have been registered successfully.</p>

        <h3>Customer Details:</h3>
        <p><strong>Customer ID:</strong> <%= request.getAttribute("customerId") %></p>
        <p><strong>Name:</strong> <%= request.getAttribute("customerName") %></p>
        <p><strong>Username:</strong> <%= request.getAttribute("customerUsername") %></p>

        <p>You will be redirected to your dashboard shortly.</p>
    </div>
    
    <script>
        // Redirect after 3 seconds (3000 ms)
        setTimeout(function() {
            window.location.href = "view_players.jsp";
        }, 5000);
    </script>
</body>
</html>
