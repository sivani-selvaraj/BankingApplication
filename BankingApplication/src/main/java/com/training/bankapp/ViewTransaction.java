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

@WebServlet("/ViewTransaction")
public class ViewTransaction extends HttpServlet{

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet4;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://localhost:3306/project1";
		String user = "root";
		String pwd = "Shivani@1235";
		HttpSession session =req.getSession();
		int acc_no=(int) session.getAttribute("accountno");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			pstmt = con.prepareStatement("Select * from transferstatus where sender_accno=?");
			pstmt.setInt(1, acc_no);
			//			pstmt.setInt(1, sender_accno);
			//			pstmt.setInt(2, sender_accno);

			resultSet4=pstmt.executeQuery();
			if(resultSet4.next()==true) {
				session.setAttribute("cust_id", resultSet4.getInt("customer_id"));
				session.setAttribute("bank_name", resultSet4.getString("bank_name"));
				session.setAttribute("ifsc_code", resultSet4.getString("sender_ifsc"));
				session.setAttribute("accountno", resultSet4.getInt("sender_accno"));
				session.setAttribute("r_ifsc_code", resultSet4.getString("receiver_ifsc"));
				session.setAttribute("r_acc_no", resultSet4.getInt("receiver_accno"));
				session.setAttribute("amount", resultSet4.getInt("amount"));
				session.setAttribute("transaction_id", resultSet4.getInt("transaction_id"));


				resp.sendRedirect("/BankingApplication/ViewTransaction.jsp");

			}
			else {
				resp.sendRedirect("/BankingApplication/ViewTransactionFail.html");
			}
		}

	catch (Exception e) {
		e.printStackTrace();
	}}
}


