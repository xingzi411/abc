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

public class ShowDireListServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			String s_page = req.getParameter("page");
			String s_pageSize = req.getParameter("pageSize");
			
			
			int page = Integer.parseInt(s_page);
			int pageSize =Integer.parseInt(s_pageSize);
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			PreparedStatement pre = conn.prepareStatement
					("SELECT * FROM v_direction limit ?,?");
			
			pre.setInt(1, (page-1)*pageSize);
			pre.setInt(2, pageSize);
			
			ResultSet rs = pre.executeQuery();
			
			List<DirectionVO> listDire = 
					new ArrayList<DirectionVO>();
			
			while(rs.next()){
				DirectionVO dv = new DirectionVO();
				dv.setDirection(rs.getString("direction"));
				dv.setId(rs.getInt("id"));
				listDire.add(dv);
			}
			
			//统计所有记录条数
			Statement sta = conn.createStatement();
			ResultSet rs2 = sta.executeQuery("SELECT count(*) total FROM v_direction");
			int total = 0;
			if(rs2.next()){
				total = rs2.getInt("total");
			}
			
			int totalPage = 0;
			if(total%pageSize == 0){
				totalPage  = total/pageSize;
			}else{
				totalPage  = total/pageSize+1;
			}
			
			req.setAttribute("totalPage",totalPage);
			req.setAttribute("listDire",listDire);
			req.getRequestDispatcher("dire_list.jsp").forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
