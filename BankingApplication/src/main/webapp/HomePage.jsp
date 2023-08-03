<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to the Bank</title>
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
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0px 2px 20px rgba(0, 0, 0, 0.1);
      max-width: 600px;
    }
    h1 {
      margin-top: 0;
      color: #333333;
    }
    p {
      font-size: 18px;
      color: #555555;
      margin-bottom: 20px;
    }
    a {
      display: block;
      margin: 10px 0;
      padding: 10px;
      border-radius: 5px;
      background-color: #3498db; /* Blue color for links */
      color: #ffffff;
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
    <h1>Welcome to the Bank</h1>
    <p>
      <%
      session = request.getSession();
      String s1 = (String) session.getAttribute("customername");
      out.print(s1 + ", welcome to your account. Please select an operation to perform:");
      %>
    </p>
    <a href="CheckBalance">1. Check Balance</a>
    <a href="ChangePassword.html">2. Change Password</a>
    <a href="Loan.jsp">3. Apply Loan</a>
    <a href="Transfer.html">4. Transfer Amount</a>
    <a href="ViewTransaction">5. View Transaction Details</a>
    <a href="Logout">6. Logout</a>
  </div>
</body>
</html>
