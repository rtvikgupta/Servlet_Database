package com.capgemini.lab3.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.lab3.dbservice.DbConnection;

/**
 * Servlet implementation class ResponseServlet
 */
public class ResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int seat = Integer.parseInt(request.getParameter("seat"));
		if(seat!=0)
		{
			String tname = request.getParameter("tname");
			out.print("Hi you have successfully enrolled for "+tname+" training");
			out.print("<br><a href='DbServlet'><< Back</a>");
			try {
				Connection con = new DbDaoImpl().getConnection();
				Statement st = con.createStatement();
				String sql = "UPDATE TRAINING SET AvailableSeats = '"+--seat+"'WHERE TrainingName = '"+tname+"'";
				ResultSet rs = st.executeQuery(sql);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		else
		{
			out.print("Sorry no seats available for this training!!!");
			RequestDispatcher rd = request.getRequestDispatcher("DbServlet");
			rd.include(request, response);
		}
	}


}
