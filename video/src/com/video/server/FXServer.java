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

public class FXServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			//解决Post提交乱码
			req.setCharacterEncoding("utf-8");
			String dire = req.getParameter("dire");
			//get提交乱码
			//dire = new String(dire.getBytes("ISO-8859-1"),"UTF-8"); 
			System.out.println(dire);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			PreparedStatement pre = 
	conn.prepareStatement("INSERT INTO v_direction(direction) VALUES(?)");
			
			
			pre.setString(1,dire);
			
			pre.executeUpdate();
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
