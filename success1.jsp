<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="refresh" content="3;url=dashboard2.jsp"> <!-- Redirect to login.jsp after 3 seconds -->
    <title>Success</title>
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
        <h1>Success!</h1>
        <p>Your booking has been confirmed successfully.</p>
        <p>You will be redirected to the login page shortly.</p>
    </div>
</body>
</html>
