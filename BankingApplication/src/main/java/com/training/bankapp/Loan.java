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


@WebServlet("/Loan")
public class Loan extends HttpServlet{
	
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet resultSet;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		HttpSession session =req.getSession();
		//int acc_no=(int) session.getAttribute("accountno");
		
        int choice = Integer.parseInt(req.getParameter("choice"));
        
        String url = "jdbc:mysql://localhost:3306/project1";

        String user = "root";

        String pwd = "Shivani@1235";

        

        //Database connection

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(url, user, pwd);


            pstmt = con.prepareStatement("Select * from loan where Loan_id=?");

            pstmt.setInt(1, choice);
            resultSet=pstmt.executeQuery();
            
            
            if(resultSet.next()==true) {
            	session.setAttribute("Loan_id", resultSet.getInt("Loan_id"));
            	session.setAttribute("Loan_type", resultSet.getString("Loan_type"));
            	session.setAttribute("Tenure", resultSet.getInt("Tenure"));
            	session.setAttribute("Rate_of_Interest", resultSet.getInt("Rate_of_Interest"));
            	session.setAttribute("Description", resultSet.getString("Description"));
            	session.setAttribute("Loan_type", resultSet.getString("Loan_type"));
            	
            	
                resp.sendRedirect("/BankingApplication/LoanDetails.jsp");

            }

            else {

                resp.sendRedirect("/BankingApplication/LoanDetailsFail.html");

            }

            

        }

        catch (Exception e) {

            e.printStackTrace();

        }}
}
