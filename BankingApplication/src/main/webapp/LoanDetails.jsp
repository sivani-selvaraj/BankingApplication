<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Viewing Details Successful</title>
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
    h3 {
      color: #333333;
      margin-bottom: 20px;
    }
    pre {
      margin: 5px 0;
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
    <h3>LOAN DETAILS</h3>
    <%
    session = request.getSession();
    out.println("Loan ID: " + session.getAttribute("Loan_id"));
    out.println("<pre> </pre>");
    out.println("Loan Type: " + session.getAttribute("Loan_type"));
    out.println("<pre> </pre>");
    out.println("Tenure: " + session.getAttribute("Tenure"));
    out.println("<pre> </pre>");
    out.println("Rate of Interest: " + session.getAttribute("Rate_of_Interest"));
    out.println("<pre> </pre>");
    out.println("Description: " + session.getAttribute("Description"));
    out.println("<pre> </pre>");
    %>
    <br><br>
    <a href="HomePage.jsp">Click here to Redirect</a>
  </div>
</body>
</html>
