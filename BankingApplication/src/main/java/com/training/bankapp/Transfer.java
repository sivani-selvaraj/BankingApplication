package com.training.bankapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Transfer")

public class Transfer extends HttpServlet{
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;
	private ResultSet resultSet2;
	private ResultSet resultSet3;
	private ResultSet resultSet4;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=req.getSession();
		
		int cust_id= Integer.parseInt(req.getParameter("customer_id"));
		String bank_name= req.getParameter("bank_name");
		String ifsc_code= req.getParameter("sender_ifsc");
		int acc_no= Integer.parseInt(req.getParameter("sender_accno"));
		String r_ifsc_code= req.getParameter("receiver_ifsc");
		int r_acc_no= Integer.parseInt(req.getParameter("receiver_accno"));
		int amount= Integer.parseInt(req.getParameter("amount"));
		int pin= Integer.parseInt(req.getParameter("pin"));



		String url = "jdbc:mysql://localhost:3306/project1";

		String user = "root";

		String pwd = "Shivani@1235";




		//Database connection

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);


			pstmt = con.prepareStatement("Select * from bankapp where customer_id=? and ifsc_Code=? and acc_no=? and pin=?");

			pstmt.setInt(1, cust_id);
			pstmt.setString(2, ifsc_code);
			pstmt.setInt(3, acc_no);
			pstmt.setInt(4, pin);

			resultSet=pstmt.executeQuery();


			if(resultSet.next()==true) {

				pstmt = con.prepareStatement("Select * from bankapp where ifsc_Code=? and acc_no=?");

				pstmt.setString(1, r_ifsc_code);
				pstmt.setInt(2, r_acc_no);

				resultSet2=pstmt.executeQuery();

				if(resultSet2.next()==true) {
					pstmt = con.prepareStatement("Select balance from bankapp where acc_no=?");

					pstmt.setInt(1, acc_no);


					resultSet3=pstmt.executeQuery();


					resultSet3.next();

					int bal =resultSet3.getInt(1);

					if(bal>amount) { 
						pstmt = con.prepareStatement("update bankapp set balance=balance-? where acc_no=?");
						pstmt.setInt(1, amount);
						pstmt.setInt(2, acc_no);

						int x1=pstmt.executeUpdate();


						if(x1>0) {
							pstmt = con.prepareStatement("update bankapp set balance=balance+? where acc_no=?");

							pstmt.setInt(1, amount);
							pstmt.setInt(2, r_acc_no);

							int x2=pstmt.executeUpdate();

							if(x2>0) {

								pstmt = con.prepareStatement("Insert into transferstatus values (?,?,?,?,?,?,?,?)");

								pstmt.setInt(1, cust_id);
								pstmt.setString(2, bank_name);
								pstmt.setString(3, ifsc_code);
								pstmt.setInt(4, acc_no);
								pstmt.setString(5, r_ifsc_code);
								pstmt.setInt(6, r_acc_no);
								pstmt.setInt(7, amount);
								int i=new Random().nextInt(900000)+100000;
								pstmt.setInt(8, i);



								int x3=pstmt.executeUpdate();

								if(x3>0) {



									//									pstmt = con.prepareStatement("Select * from transferstatus where customer_id=?");
									//									pstmt.setInt(1, cust_id);
									//									pstmt.setInt(1, sender_accno);
									//									pstmt.setInt(2, sender_accno);
									//									
									//									resultSet4=pstmt.executeQuery();
									//									if(resultSet4.next()==true) {
									//										session.setAttribute("cust_id", resultSet4.getInt("customer_id"));
									//						            	session.setAttribute("bank_name", resultSet4.getString("bank_name"));
									//						            	session.setAttribute("ifsc_code", resultSet4.getString("sender_ifsc"));
									//						            	session.setAttribute("accountno", resultSet4.getInt("sender_accno"));
									//						            	session.setAttribute("r_ifsc_code", resultSet4.getString("receiver_ifsc"));
									//						            	session.setAttribute("r_acc_no", resultSet4.getInt("receiver_accno"));
									//						            	session.setAttribute("amount", resultSet4.getInt("amount"));
									//						            	session.setAttribute("transaction_id", resultSet4.getInt("transaction_id"));

									resp.sendRedirect("/BankingApplication/TransferSuccess.html");

								}


								else {
									resp.sendRedirect("/BankingApplication/TransferFail.html");
								}


							}
							else {
								resp.sendRedirect("/BankingApplication/TransferFail.html");
							}}
						else {
							resp.sendRedirect("/BankingApplication/TransferFail.html");
						}}
					else {
						resp.sendRedirect("/BankingApplication/TransferFail.html");
					}}
				else {
					resp.sendRedirect("/BankingApplication/TransferFail.html");
				}}
			else {
				resp.sendRedirect("/BankingApplication/TransferFail.html");
			}}


		catch (Exception e) {

			e.printStackTrace();



		}

	}
}
