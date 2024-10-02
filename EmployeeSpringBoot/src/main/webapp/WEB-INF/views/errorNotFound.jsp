<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error Page</title>
<style>
		.home-btn {
        	background-color: #007bff;
            color: white;
            border: none;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s, transform 0.2s;
            padding: 15px 32px; /* Padding */
            text-align: center; /* Centered text */
            text-decoration: none; /* Remove underline */
            display: inline-block; /* Make the button inline with other elements */
            margin: 10px; /* Margin around buttons */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transitions */
        }
        .home-btn:hover {
            background-color: #007bff; /* Darker green background on hover */
            transform: scale(1.05); /* Slightly enlarge the button */
        }
</style>
</head>
<body style="text-align:center">

<div>
	<%@ include file="/WEB-INF/views/index.jsp" %>
</div>

<div>
<h3>${message}</h3>
<button id="homeButton" class="home-btn">Go Home</button><br>

</div>

	<script>
        document.getElementById('homeButton').addEventListener('click', function() {
            window.location.href = '${page}';
        });
    </script>
</body>
</html>