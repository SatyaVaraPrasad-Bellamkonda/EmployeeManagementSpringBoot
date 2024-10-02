<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Sign-Up/Login</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
            margin: 0;
        }
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 350px;
            max-width: 100%;
        }
        .toggle-buttons {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
        }
        .toggle-buttons button {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
            margin-right: 10px;
        }
        .toggle-buttons button:last-child {
            margin-right: 0;
        }
        .toggle-buttons button:hover {
            background-color: #0056b3;
        }
        .form {
            display: none;
        }
        .form.active {
            display: block;
        }
        h2 {
            margin: 0 0 20px 0;
            font-size: 24px;
        }
        input[type="text"], input[type="tel"], input[type="email"],input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 5px;
            background-color: #007bff;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
         .popup {
            display: none; /* Hidden by default */
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: #ffffff; /* White background */
            border: 1px solid #ddd; /* Light gray border */
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.2);
            z-index: 1000;
            text-align: center;
        }

        .popup p {
            color: #ff0000; /* Red text for error message */
            margin-bottom: 20px;
        }

        .popup button {
            background-color: #007BFF; /* Blue background */
            color: #ffffff; /* White text */
            border: none;
            border-radius: 5px;
            padding: 10px 15px;
            cursor: pointer;
            font-size: 14px;
        }

        .popup button:hover {
            background-color: #0056b3; /* Darker blue background on hover */
        }
    </style>
</head>
<body>

    <div class="container">
        <div class="toggle-buttons">
            <button onclick="showForm('login')">Login</button>
            <button onclick="showForm('signup')">Sign Up</button>
        </div>
        
        <div id="login-form" class="form" >
       <%--  <c:if test="${not empty message}">
            <div class="popup">
                <p>Error In Login </p>
                <button onclick="closePopup()">Close</button>
            </div>
        </c:if>  --%>
         <div class="popup">
                <p>Invalid Login Credentials / Manager Approval Required</p>
                <button onclick="closePopup()">Close</button>
            </div> 
            <h2>Login</h2>
            <!-- <form action="employeeLoginValidate" method="POST"> -->
            <form action="loginP" method="POST">
                <input type="text" placeholder="Username" name="username" required>
                <input type="password" placeholder="Password" name="password" required>
                <input type="submit" value="Login">
            </form>
        </div>
        
        <div id="signup-form" class="form">
            <h2>Sign Up</h2>
            <form action="employeeSignUpValidate" method="POST">
                <input type="text" placeholder="Full Name" name="name" required>
                <input type="email" placeholder="Email" name="mail" required>
                <input type="tel" placeholder="mobile" name="mobile" required>
                <input type="text" placeholder="username" name="username" required>
                <input type="password" placeholder="password" name="password" required>
                <input type="submit" value="Sign Up">
            </form>
        </div>
    </div>

    <script>
        function showForm(formType) {
            document.getElementById('login-form').classList.remove('active');
            document.getElementById('signup-form').classList.remove('active');
            
            if (formType === 'login') {
                document.getElementById('login-form').classList.add('active');
            } else if (formType === 'signup') {
                document.getElementById('signup-form').classList.add('active');
            }
        }
        
        // Default to showing login form
       showForm('login');
        
        function showPopup() {
            document.querySelector('.popup').style.display = 'block';
        }

        // Function to close the popup
        function closePopup() {
            document.querySelector('.popup').style.display = 'none';
        }

        // Display the popup if the message is present
        window.onload = function() {
            if (document.querySelector('.popup')) {
                showPopup();
            }
            
        }; 
    </script>
</body>
</html>
