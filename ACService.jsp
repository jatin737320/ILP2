<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TV Repair - Services APP</title>
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
            background-color: rgba(255, 255, 255, 0.1);
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 450px;
            margin: 20px auto;
            text-align: center;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
            text-align: left;
        }

        input, select {
            background-color: rgba(255, 255, 255, 0.1);
            margin-bottom: 15px;
            padding: 10px;
            width: 100%;
            border-radius: 8px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-size: 16px;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 12px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #0056b3;
        }

        footer {
            text-align: center;
            margin-top: 20px;
            color: #333;
        }

        h1, h2 {
            text-align: center;
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
        <a href="WashingMachineService.jsp">Washing Machine Repair</a>
        <!--<a href="ProductDrop.jsp">Product Pick/Drop</a>-->
        <a href="ACService.jsp">AC Repair</a>
        <!--<a href="HouseCleaning.jsp">House Cleaning</a>-->
        <a href="Logout.jsp" class="logout">Logout</a>
    </div>

    <header>
        <h1>AC Repair/Service</h1>
    </header>

    <div class="container">
        <section class="tv-repair-form">
            <h2>Book a TV Repair Slot</h2>
            <form action="ServiceServlet" id = "ServiceForm">
                <!-- Requester Name -->
                <label for="requesterName">Requester Name</label>
                <input type="text" id="requesterName" name="requesterName" required>

                <!-- Contact Number -->
                <label for="contactNumber">Contact Number</label>
                <input type="text" id="contactNumber" name="contactNumber" required>

                <!-- Email -->
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>

                <!-- Address -->
                <label for="address">Address</label>
                <input type="text" id="address" name="address" required>

                <!-- Date and Time Slot -->
                <label for="dateSlot">Select Date/Slot</label>
                <input type="datetime-local" id="dateSlot" name="dateSlot" required>

                <input type="hidden" name="serviceName" value="Referigerator Repair" />

                <!-- Submit Button -->
                <button type="submit">Confirm Booking</button>
            </form>
        </section>
    </div>

    <footer>
        <p>© 2024 Services APP. All rights reserved.</p>
    </footer>

    <script>
    
    	
        document.getElementById('ServiceForm').addEventListener('submit', function(e) {
            //e.preventDefault();

            const dateTimeInput = document.getElementById('dateSlot').value;
            const [datePart, timePart] = dateTimeInput.split('T');

            // Format: yyyy-MM-ddTHH:mm
            const [year, month, day] = datePart.split('-').map(Number);
            const [hours, minutes] = timePart.split(':').map(Number);

            // Hardcoded values for hours and minutes
            var hardcodedHours = 10;  // Replace with your desired hour value
            var hardcodedMinutes = 30; // Replace with your desired minute value

            // Format the time (HH-mm)
           // var timeFormatted = (hardcodedHours < 10 ? '0' + hardcodedHours : hardcodedHours) + '-' + (hardcodedMinutes < 10 ? '0' + hardcodedMinutes : hardcodedMinutes);
            //var timePattern = /^\d{2}-\d{2}$/; // HH-mm
            var isTimeValid = timePattern.test(timeFormatted);
            console.log("Formatted Time: ", timeFormatted);
            console.log("Is Time Valid: ", isTimeValid);

            // Generate formatted date
            
            var timeFormatted = (hardcodedHours < 10 ? '0' + hardcodedHours : hardcodedHours) + ':' + (hardcodedMinutes < 10 ? '0' + hardcodedMinutes : hardcodedMinutes);

                // Generate formatted date in yyyy-mm-dd
            const dateFormatted = `${year}-${month < 10 ? '0' + month : month}-${day < 10 ? '0' + day : day}`;

           // const dateFormatted = day + '-' + month + '-' + year;
            //const datePattern = /^\d{2}-\d{2}-\d{4}$/; // dd-MM-yyyy
            const isDateValid = datePattern.test(dateFormatted);
            console.log("Formatted Date: ", dateFormatted);
            console.log("Is Date Valid: ", isDateValid);

            // Check if both date and time are valid
            if (!isDateValid) {
                alert("Invalid date format. Please use dd-MM-yyyy.");
                return;
            }
            if (!isTimeValid) {
                alert("Invalid time format. Please use HH-mm.");
                return;
            }

            // Generate a random Order ID
            const orderId = 'TVR' + Math.floor(Math.random() * 1000000);

            // Store the Order ID in localStorage for use in the success page
            localStorage.setItem('orderId', orderId);

            // Redirect to the success page
            window.location.href = 'success1.jsp';
        
        /*
        document.getElementById('ServiceForm').addEventListener('submit', function(e) {
                // e.preventDefault(); // Ensure this remains commented out

                const dateTimeInput = document.getElementById('dateSlot').value;
                const [datePart, timePart] = dateTimeInput.split('T');

                // Format: yyyy-MM-ddTHH:mm
                const [year, month, day] = datePart.split('-').map(Number);
                const [hours, minutes] = timePart.split(':').map(Number);

                // Hardcoded values for hours and minutes
                var hardcodedHours = 10;  // Replace with your desired hour value
                var hardcodedMinutes = 30; // Replace with your desired minute value

                // Format the time (HH:mm)
                var timeFormatted = (hardcodedHours < 10 ? '0' + hardcodedHours : hardcodedHours) + ':' + (hardcodedMinutes < 10 ? '0' + hardcodedMinutes : hardcodedMinutes);

                // Generate formatted date in yyyy-mm-dd
                const dateFormatted = `${year}-${month < 10 ? '0' + month : month}-${day < 10 ? '0' + day : day}`;

                // Log values for debugging
                console.log("Formatted Date: ", dateFormatted);
                console.log("Formatted Time: ", timeFormatted);

                // Check if date and time are valid (You may add further validation here)

                // Generate a random Order ID
                const orderId = 'TVR' + Math.floor(Math.random() * 1000000);

                // Store the Order ID in localStorage for use in the success page
                localStorage.setItem('orderId', orderId);

                // Redirect to the success page
                window.location.href = 'success1.jsp';
           
        });*/
    </script>
</body>
</html>
