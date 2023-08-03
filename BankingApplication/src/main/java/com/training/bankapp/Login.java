package com.training.bankapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")

public class Login extends HttpServlet{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        int cust_id = Integer.parseInt(req.getParameter("customer_id"));
        int pin = Integer.parseInt(req.getParameter("pin"));
        
        String url = "jdbc:mysql://localhost:3306/project1";

        String user = "root";

        String pwd = "Shivani@1235";
        
        HttpSession session=req.getSession(true);

        

        //Database connection

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pwd);


            pstmt = con.prepareStatement("Select * from bankapp where customer_id=? and pin=?");

            pstmt.setInt(1, cust_id);
            pstmt.setInt(2, pin);
            resultSet=pstmt.executeQuery();
            
            
            if(resultSet.next()==true) {
            	session.setAttribute("accountno", resultSet.getInt("acc_no"));
            	session.setAttribute("customername", resultSet.getString("customer_name"));
            	
                resp.sendRedirect("/BankingApplication/HomePage.jsp");

            }

            else {

                resp.sendRedirect("/BankingApplication/LoginFail.html");

            }

            

        }

        catch (Exception e) {

            e.printStackTrace();

        }}
}
