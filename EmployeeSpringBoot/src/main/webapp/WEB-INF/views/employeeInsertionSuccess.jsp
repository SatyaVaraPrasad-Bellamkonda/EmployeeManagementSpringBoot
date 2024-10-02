<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Data Inserted</title>

<style>
        body, h2, h4, h5, form, input {
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
            color: #28a745; /* Green color for success message */
            margin-bottom: 20px;
        }
        h4 {
            color: #333;
            margin-bottom: 15px;
        }
        h5 {
            color: #555;
            margin: 10px 0;
            font-size: 18px;
        }
      
  
        .btn-sccs {
        	  background-color: #007bff;
            color: white;
            border: none;
            font-size: 16px;
            cursor: pointer;
            border-radius: 4px;
            transition: background-color 0.3s, transform 0.2s;
        
        
            padding: 15px 32px; /* Padding */
            text-align: center; /* Centered text */
            text-decoration: none; /* Remove under line */
            display: inline-block; /* Make the button inline with other elements */
            font-size: 16px; /* Increase font size */
            margin: 10px; /* Margin around buttons */
            cursor: pointer; /* Pointer cursor on hover */
            border-radius: 5px; /* Rounded corners */
            transition: background-color 0.3s ease, transform 0.3s ease; /* Smooth transitions */
        }
        
        .btn-sccs:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
       .btn-sccs:active {
            background-color: #00408d;
        }
        
        
    </style>

</head>
<body>
<div>
	<%@ include file="/WEB-INF/views/index.jsp" %>
	</div>
<div>
<h2> Data Inserted Successfully </h2>
<h4>The Inserted Data is : </h4>
<h5>ID Number = ${data.id }</h5>
<h5>Name = ${data.name }</h5>
<h5>Mobile = ${data.mobilenum }</h5>
<h5>Email = ${data.mail_id }</h5>
<h5>Batch = ${data.batch }</h5>
<h5>Place = ${data.place }</h5>
<h5>Mentor = ${data.mentor }</h5>
<button id="homeButton" class="btn-sccs">Go Home</button>
<button id="addAnother" class="btn-sccs">Add Another Detail</button>
</div>
	<script>
        document.getElementById('homeButton').addEventListener('click', function() {
            window.location.href = 'index';
        });
        document.getElementById('addAnother').addEventListener('click', function() {
            window.location.href = 'insertEmployeeDetails';
        });
    </script>

</body>
</html>