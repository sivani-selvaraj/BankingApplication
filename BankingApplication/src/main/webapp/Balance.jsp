<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Current Balance</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
    }
    .container {
      text-align: center;
      background-color: #ffffff;
      padding: 40px;
      border-radius: 8px;
      box-shadow: 0px 2px 20px rgba(0, 0, 0, 0.1);
      max-width: 400px;
    }
    h4 {
      color: #27ae60; /* Green color for success message */
      margin-bottom: 20px;
    }
    a {
      display: block;
      background-color: #3498db; /* Blue color for link */
      color: #ffffff;
      padding: 10px 20px;
      border-radius: 4px;
      text-decoration: none;
      transition: background-color 0.3s;
    }
    a:hover {
      background-color: #2980b9; /* Darker blue color on hover */
    }
  </style>
</head>
<body>
  <div class="container">
    <h4>
      <%
      session = request.getSession();
      out.println("Your Current Balance is: " + session.getAttribute("balance"));
      %>
    </h4>
    <a href="HomePage.jsp">Click here to Redirect</a>
  </div>
</body>
</html>
