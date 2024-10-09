<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.IOException" %>
<%
    // Invalidate the current session to log the user out
    HttpSession sessions = request.getSession(false);  // Fetch session if exists, don't create a new one
    if (sessions != null) {
        sessions.invalidate();  // Invalidate the session, logging the user out
    }

    // Redirect to login page (or home page) after logout
    response.sendRedirect("login.jsp");  // Replace with your login page path
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Logging Out...</title>
</head>
<body>
    <!-- This message is shown briefly in case redirect fails -->
    <p>You are being logged out. If you're not redirected, <a href="login.jsp">click here</a>.</p>
</body>
</html>
