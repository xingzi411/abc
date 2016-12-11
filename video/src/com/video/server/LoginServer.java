package com.video.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			String user = req.getParameter("user");
			String pass = req.getParameter("pass");
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM v_admin WHERE login_name=? AND password=?");
			
			pre.setString(1, user);
			pre.setString(2, pass);
			
			ResultSet rs = pre.executeQuery();
			
			if(rs.next()){
				resp.sendRedirect("success.html");
			}else{
				req.setAttribute("error", "用户名或密码错误");
				req.getRequestDispatcher("login.jsp")
						.forward(req, resp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
