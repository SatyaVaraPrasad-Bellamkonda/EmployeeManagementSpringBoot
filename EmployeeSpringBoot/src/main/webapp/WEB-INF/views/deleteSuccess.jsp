<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Deleted</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
            padding: 10px;
            text-align: left;
            border-bottom: 2px solid #ddd;
        }
        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th {
            font-size: 1.1em;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
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
<body>
<div>
	<%@ include file="/WEB-INF/views/index.jsp" %>
	</div>


<div>
<h2> Data Deleted Successfully </h2>
<h2>The Deleted Data is : </h2>
<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Mobile</th>
				<th>Email Id</th>
				<th>Batch</th>
				<th>Place</th>
				<th>Mentor</th>
			</tr>
			
		</thead>
	<c:forEach var="eachValue" items="${values }">
	
	
	
		<tbody>
			<tr>
				<td>${eachValue.id}</td>
				<td>${eachValue.name}</td>
				<td>${eachValue.mobilenum}</td>
				<td>${eachValue.mail_id}</td>
				<td>${eachValue.batch}</td>
				<td>${eachValue.place}</td>
				<td>${eachValue.mentor}</td>
				
			</tr>
		</tbody>
	
	
	</c:forEach>
	</table>
	
	<button id="homeButton" class="home-btn">Go Home</button>
	<button id="delete" class="home-btn">Delete Again</button><br>
</div>
	<script>
        document.getElementById('homeButton').addEventListener('click', function() {
            window.location.href = 'index';
        });
        document.getElementById('delete').addEventListener('click', function() {
            window.location.href = 'employeeDeleteById';
        });
    </script>
</body>
</html>