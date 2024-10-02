<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Search</title>
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
            border: 1px soli	d #ddd;
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


<div class="table-container">
<table>
		<thead>
			<tr>
				<th colspan="2" style="text-align:center">Search Results	</th>
			</tr>
			
		</thead>
	<c:forEach var="eachValue" items="${values }">
	
		<tbody>
		<tr> <th colspan="2" style="text-align:center"> Employee Details</th></tr>
			<tr>
				<td>Employee ID </td>
				<td>${eachValue.id}</td>
			</tr>
			<tr>
			</tr>
			<tr>
				<td>Employee Name </td>
				<td>${eachValue.name}</td>
			</tr>
			<tr>
				<td>Mobile Num </td>
				<td>${eachValue.mobilenum}</td>
			</tr>
			<tr>
				<td>Mail ID </td>
				<td>${eachValue.mail_id}</td>
			</tr>
			<tr>
				<td>Batch </td>
				<td>${eachValue.batch}</td>
			</tr>
			<tr>
				<td>Work Place</td>
				<td>${eachValue.place}</td>
			</tr>
			<tr>
				<td>Mentor</td>
				<td>${eachValue.mentor}</td>
			</tr>
			<tr>
				<td>UserName</td>
				<td>${eachValue.username}</td>
			</tr>
			<tr>
				<td>Role</td>
				<td>${eachValue.role}</td>
			</tr>
			
				
		</tbody>
	
	
	</c:forEach>
	</table>
	<h2>${message}</h2><br>
	
	<button id="homeButton" class="home-btn">Go Home</button>
	<button id="addData" class="home-btn">Add Data</button>
	</div>
	<script>
        document.getElementById('homeButton').addEventListener('click', function() {
            window.location.href = 'index';
        });
        document.getElementById('addData').addEventListener('click', function() {
            window.location.href = 'insertEmployeeDetails';
        });
    </script>

</body>
</html>