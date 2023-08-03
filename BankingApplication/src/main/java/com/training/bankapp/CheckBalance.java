package com.training.bankapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CheckBalance")

public class CheckBalance extends HttpServlet{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =req.getSession();
		int acc_no=(int) session.getAttribute("accountno");

		String url = "jdbc:mysql://localhost:3306/project1";
		String user = "root";
		String pwd = "Shivani@1235";

		//Database connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement("Select balance from bankapp where acc_no=?");
			pstmt.setInt(1, acc_no);	
			resultSet=pstmt.executeQuery();
			if(resultSet.next()==true) {
				session.setAttribute("balance", resultSet.getInt("balance"));
				resp.sendRedirect("/BankingApplication/Balance.jsp");

			}
			else {
				resp.sendRedirect("/BankingApplication/BalanceFail.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}}
}

