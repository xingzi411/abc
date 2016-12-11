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

public class ShowCreateKCServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			Statement sta = conn.createStatement();
			ResultSet rs = sta.executeQuery
					("SELECT * FROM v_direction");
			List<DirectionVO> listDire = 
					new ArrayList<DirectionVO>();
			
			while(rs.next()){
				DirectionVO dv = new DirectionVO();
				dv.setDirection(rs.getString("direction"));
				dv.setId(rs.getInt("id"));
				listDire.add(dv);
			}
			req.setAttribute("listDire",listDire);
			
			req.getRequestDispatcher("create_kc.jsp")
			.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
