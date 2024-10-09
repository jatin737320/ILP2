<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<style>

* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    background-image: url("https://5.imimg.com/data5/DZ/WI/LU/SELLER-6814007/repair-maintenance.png");
    background-color: black;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
}

header {
    background-color: #333;
    color: #fff;
    width: 100%;
    text-align: center;
    padding: 15px 0;
}

header h1 {
    margin: 0;
}

nav ul {
    list-style: none;
    padding: 0;
}

nav ul li {
    display: inline;
    margin: 0 15px;
}

nav ul li a {
    color: #fff;
    text-decoration: none;
    font-size: 18px;
}

.container {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 80vh;
    width: 100%;
}

section {
    background-color: rgba(255, 255, 255, 0.7); /* White with 70% opacity */
    padding: 30px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 400px;
}

section h2 {
    margin-bottom: 20px;
    font-size: 24px;
    text-align: center;
}

footer {
    text-align: center;
    width: 100%;
    margin: 20px 0;
    padding: 10px 0;
    background-color: #333;
    color: white;
}

form {
    display: flex;
    flex-direction: column;
}

form label {
    margin-top: 10px;
    font-size: 16px;
}

form input {
    padding: 10px;
    margin-top: 5px;
    font-size: 16px;
}

form button {
    margin-top: 20px;
    padding: 10px;
    background-color: #333;
    color: white;
    border: none;
    cursor: pointer;
    font-size: 18px;
}

form button:hover {
    background-color: #555;
}

.success-message h2 {
    color: green;
    font-size: 24px;
}

</style>
<body>
	<header>
        <h1>Aircraft Maintenance Management</h1>
        <nav>
            
        </nav>
    </header>

    <div class="container">
        <section class="login-form">
            <h2>Login</h2>
            <% 
                // Check if there's an error message and display it
                String errorMessage = (String) request.getAttribute("errorMessage");
                if (errorMessage != null) { 
            %>
                <div class="error-message">
                    <p><%= errorMessage %></p>
                </div>
            <% } %>
            <form action="LoginServlet">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>

                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>

                <button type="submit">Login</button>
            </form>
        </section>
    </div>
	
</body>
</html>