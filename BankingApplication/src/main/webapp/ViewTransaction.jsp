<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>View Transaction</title>
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
    <h4>
      <%
      session = request.getSession();
      out.println("Transaction ID: " + session.getAttribute("transaction_id"));
      out.println("<pre> </pre>");
      out.println("Customer ID: " + session.getAttribute("cust_id"));
      out.println("<pre> </pre>");
      out.println("Bank Name: " + session.getAttribute("bank_name"));
      out.println("<pre> </pre>");
      out.println("IFSC Code: " + session.getAttribute("ifsc_code"));
      out.println("<pre> </pre>");
      out.println("Account Number: " + session.getAttribute("accountno"));
      out.println("<pre> </pre>");
      out.println("Receiver's IFSC Code: " + session.getAttribute("r_ifsc_code"));
      out.println("<pre> </pre>");
      out.println("Receiver's Account Number: " + session.getAttribute("r_acc_no"));
      out.println("<pre> </pre>");
      out.println("Amount: " + session.getAttribute("amount"));
      out.println("<pre> </pre>");
      %>
    </h4>
    <a href="HomePage.jsp">Click here to Redirect</a>
  </div>
</body>
</html>
