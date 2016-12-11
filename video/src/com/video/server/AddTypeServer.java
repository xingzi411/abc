package com.video.server;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.video.vo.DirectionVO;

public class AddTypeServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("utf-8");
			
			String did = req.getParameter("did");
			String tname = req.getParameter("tname");
			
			System.out.println(did+":::::"+tname);
			
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			PreparedStatement pre = conn.prepareStatement("INSERT INTO v_type(tname,did) VALUES(?,?)");
			
			pre.setString(1, tname);
			pre.setInt(2,Integer.parseInt(did));
			
			pre.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
