<%--  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%> --%>
    
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <style>
        <%@include file="/resources/style.css" %>
     
    </style>
</head>
<body>
    <div class="taskbar">
        <button id="insertButton">Add Employee</button>
        <button id="viewActiveEmployeeButton">Active Employees</button>
        <button id="deleteButton">Delete Employee</button>
        <button id="updateButton">Update Employee</button>
        <button id="viewDbDataButton">Complete Employees</button>
        <button id="viewRequests">Requests</button>
        <div class="dropdown">
            <button id="profile">Profile</button>
            <div class="dropdown-content">  
                <button id="changePasswordButton">Change Password</button>
            </div>
        </div>

        <button id="logout">Logout</button>
        
        <div class="search-bar">
            <form action="searchEmployee" class="search-bar" method="post">
                <input type="text" class="textid" name="id" placeholder="Search for employees...">
                <input type="submit" placeholder="Submit">
            </form> 
        </div>
    </div>
    <script type="text/javascript"><%@include file="/resources/script.js" %></script>
</body>
</html>
