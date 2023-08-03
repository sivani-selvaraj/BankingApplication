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

@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String url = "jdbc:mysql://localhost:3306/project1";
		String user = "root";
		String pwd = "Shivani@1235";
		HttpSession session =req.getSession();
		int acc_no=(int) session.getAttribute("accountno");
		
//		int pin= Integer.parseInt(req.getParameter("pin"));
//		int new_pin= Integer.parseInt(req.getParameter("pin1"));
//		int confirm_pin= Integer.parseInt(req.getParameter("pin2"));
//		
		
		String pin=req.getParameter("pin");
		String new_pin=req.getParameter("pin1");
		String confirm_pin=req.getParameter("pin2");
		
		
		if(new_pin.equals(confirm_pin)) {
			
		

		//Database connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement("update bankapp set pin=? where acc_no=? and pin=? ");
			pstmt.setString(1, new_pin);
			pstmt.setInt(2, acc_no);
			pstmt.setString(3, pin);
			
			
			int resultSet=pstmt.executeUpdate();
			if(resultSet>0) {
				
				resp.sendRedirect("/BankingApplication/PasswordChangeSuccess.html");

			}
			else {
				resp.sendRedirect("/BankingApplication/PasswordChangeFailed.html");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}}
		else {
			resp.sendRedirect("/BankingApplication/PasswordChangeFailed.html");
		}

		// TODO Auto-generated method stub
		
		
		
		
		
	}}
	