package com.moytri.springdemo.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestDBServlet
 */
@WebServlet("/TestDBServlet")
public class TestDBServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//setup connection variable
		String user = "springstudent";
		String pass = "springstudent";
		
		String url = "jdbc:mysql://localhost:3306/techno_blog?useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.jdbc.Driver";
		
		//get connection
		try {
			PrintWriter out = response.getWriter();
			
			out.println("connecting to " + url);
			
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, user, pass);
			
			out.print("Connection successful!");
			
			con.close();
		}
		catch(Exception ex) {
			ex.printStackTrace();
			throw new ServletException(ex);
		}
		
	}

}
