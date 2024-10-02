<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome Page</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #e0f7fa; /* Light blue background */
            color: #333;
            text-align: center;
            margin: 0;
            padding: 0;
            height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            background-image: linear-gradient(to right, #e0f7fa, #b2ebf2);
        }
        .welcome-message {
            background-color: #ffffff;
            border-radius: 15px;
            padding: 40px;
            width: 90%;
            max-width: 500px;
            box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s, box-shadow 0.3s;
        }
        .welcome-message:hover {
            transform: translateY(-5px);
            box-shadow: 0 12px 40px rgba(0, 0, 0, 0.3);
        }
        h1 {
            font-size: 2.5em;
            color: #007bff; /* Darker blue */
            margin: 0 0 20px;
        }
        p {
            font-size: 1.3em;
            margin: 10px 0;
            color: #555;
        }
        .btn {
            display: inline-block;
            background-color: #007bff;
            color: white;
            padding: 12px 25px;
            text-decoration: none;
            border-radius: 5px;
            font-size: 1.1em;
            transition: background-color 0.3s, transform 0.3s;
        }
        .btn:hover {
            background-color: #0056b3; /* Darker on hover */
            transform: scale(1.05);
        }
        @media (max-width: 600px) {
            h1 {
                font-size: 2em;
            }
            p {
                font-size: 1.1em;
            }
        }
    </style>
</head>
<body>
<div>
	<%@ include file="/WEB-INF/views/index.jsp" %>
	</div>
    <div class="welcome-message">
        <h1>Hii ${name },</h1>
        <p>Welcome to the Employee Management System!</p>
        <p>Proceed with your requirements.</p>
        <a href="index" class="btn">Get Started</a>
    </div>
</body>
</html>
