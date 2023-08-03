<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Loan Type Selection</title>
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
      font-size: 18px;
      margin: 0;
      padding: 0;
    }
    form {
      margin-top: 20px;
      text-align: center;
    }
    label {
      display: block;
      font-weight: bold;
      color: #555555;
      margin-bottom: 5px;
    }
    input[type="text"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 20px;
      border: 1px solid #e1e1e1;
      border-radius: 4px;
    }
    input[type="submit"] {
      background-color: #3498db;
      color: #ffffff;
      border: none;
      border-radius: 4px;
      padding: 10px 20px;
      font-weight: bold;
      cursor: pointer;
      transition: background-color 0.3s;
    }
    input[type="submit"]:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
  <div class="container">
    <h3>
      1. Home Loan<br><br>
      2. Education Loan<br><br>
      3. Vehicle Loan<br><br>
      4. Personal Loan<br><br>
      5. Gold Loan
    </h3>
    <form action="Loan" method="get">
      <label for="choice">Enter your choice:</label>
      <input type="text" id="choice" name="choice" required>
      <input type="submit" value="Submit">
    </form>
  </div>
</body>
</html>
