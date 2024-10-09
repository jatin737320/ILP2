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
	
	<%
	String errorMessage = (String) request.getAttribute("errorMessage");
	
	if (errorMessage!=null)
	{
	%>
	
	<p style = "color:red;"><%= errorMessage %></p>
	
	<%
	}	
	%>
	
	<header>
		<h1>Services</h1>
		<nav>
            <!--<ul>
                <li><a href="registration.html">Register</a></li>
                <li><a href="login.html">Login</a></li>
            </ul>-->
        </nav>
	</header>
	
	<div class="container">
        <section class="registration-form">
			<form action="CusServlet2" method="post" onsubmit="return validateForm()">
		    	<!-- Name -->
		    	<label for="name">Name:</label>
		    	<input type="text" id="name" name="name"><br>
		
		    	<!-- Username -->
		    	<label for="username">Username:</label>
		    	<input type="text" id="username" name="username"><br>
		
		    	<!-- Email -->
		    	<label for="email">Email:</label>
		    	<input type="text" id="email" name="email">
		    	<span id="email-error" style="color:red"></span><br>
		
		    	<!-- Contact -->
		    	<label for="contact">Contact Number:</label>
		    	<input type="text" id="contact" name="contact">
		    	<span id="contact-error" style="color:red"></span><br>
		
		    	<!-- Password -->
		    	<label for="password">Password:</label>
		    	<input type="password" id="password" name="password">
		    	<span id="password-error" style="color:red"></span><br>
		
				<label for="address">Address: </label>
				<input type = "text" id = "address" name = "address">
				
		    	<!-- Submit -->
		    	<input type="submit" value="Submit">
			</form>
		</section>
	</div>

	
	<script>
		// Validation for form fields
		function validateForm() {
    		var email = document.getElementById("email").value;
    		var contact = document.getElementById("contact").value;
    		var password = document.getElementById("password").value;

    		var emailError = document.getElementById("email-error");
    		var contactError = document.getElementById("contact-error");
    		var passwordError = document.getElementById("password-error");

    		var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    		var contactRegex = /^(0|91)?[6-9]\d{9}$/;  // Indian contact number format
    		var passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

    		var valid = true;

    		// Validate Email
    		if (!emailRegex.test(email)) {
        		emailError.innerText = "Please enter a valid email (e.g., user@example.com).";
        		valid = false;
    		} else {
        		emailError.innerText = "";
    		}

    		// Validate Contact Number
    		if (!contactRegex.test(contact)) {
        		contactError.innerText = "Please enter a valid contact number starting with 6-9, having 10 digits.";
        		valid = false;
    		} else {
        		contactError.innerText = "";
    		}

    		// Validate Password
    		if (!passwordRegex.test(password)) {
        		passwordError.innerText = "Password must contain at least one lowercase letter, one uppercase letter, one digit, and one special character.";
        		valid = false;
    		} else {
        		passwordError.innerText = "";
    		}

    		
    		if (name.trim() === "") {
        		nameError.innerText = "Name is required.";
        		valid = false;
    		} else {
        		nameError.innerText = "";
    		}

    		// Validate Username
    		if (username.trim() === "") {
        		usernameError.innerText = "Username is required.";
        		valid = false;
    		} else {
        		usernameError.innerText = "";
    		}
    		
    		return valid; // Prevent form submission if validation fails
		}
	</script>

	
</body>
</html>