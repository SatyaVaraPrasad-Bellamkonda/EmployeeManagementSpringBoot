<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Details Here</title>
 <style>
        body, h2, form, input {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }
        h2 {
            color: #333;
            margin-bottom: 20px;
        }
        .form-form {
            display: inline-block;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: left;
        }
       .form-form input[type="number"],
       .form-form input[type="text"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }
       .form-form input::placeholder {
            color: #888;
        }
        .form-form input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s, transform 0.2s;
            width: 100%;
        }
        .form-form input[type="submit"]:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
        .form-form input[type="submit"]:active {
            background-color: #00408d;
        }
        select {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #f9f9f9;
    cursor: pointer;
    transition: border-color 0.3s;
}

select:focus {
    border-color: #66afe9; /* Highlight border on focus */
    outline: none; /* Remove outline */
}

option {
    padding: 10px; /* Padding inside options for better touch targets */
}
    </style>
</head>
<body style="text-align:center">

<div>
	<%@ include file="/WEB-INF/views/index.jsp" %>
</div>
<div>
<h2>Edit User Information</h2>
	<c:forEach var="eachValue" items="${user}">
    <form action="updateUser" method="post" class="form-form">
        <input type="hidden" name="id" value="${eachValue.id}"/>
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" value="${eachValue.name}" required/><br/>
        <label for="mobile">Mobile:</label>
        <input type="text" id="mobile" name="mobilenum" value="${eachValue.mobilenum}" required/><br/>
        <label for="mail">Email:</label>
        <input type="text" id="email" name="mail_id" value="${eachValue.mail_id}" required/><br/>
        <label for="batch">Batch:</label>
        <input type="text" id="email" name="batch" value="${eachValue.batch}" required/><br/>
        <label for="place">WorkPlace:</label>
        <input type="text" id="email" name="place" value="${eachValue.place}" required/><br/>
        <label for="mentor">Mentor:</label>
        <input type="text" id="email" name="mentor" value="${eachValue.mentor}" required/><br/>
        <label for="mentor">UserName:</label>
        <input type="text" id="username" name="username" value="${eachValue.username}" required/><br/>
        <label for="mentor">Role:</label>
        <input type="text" id="role" name="role" value="${eachValue.role}" required/><br/>
        <label for="locked">Status:</label>
        <select id="booleanValue" name="locked" >
            <option value="false">Active</option>
            <option value="true">Lock</option>
        </select>
        <input type="submit" value="Update"/>
    </form>
    </c:forEach>
</div>


</body>
</html>