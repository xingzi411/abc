package com.video.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.video.vo.DTypeVO;
import com.video.vo.DirectionVO;

public class FindTypeServer extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		try {
			int did  = Integer.parseInt(req.getParameter("did"));
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.
					getConnection("jdbc:mysql://localhost:3306/video", "root","123456");
			
			PreparedStatement pre = conn.prepareStatement("SELECT * FROM v_type WHERE did=?");
			
			pre.setInt(1, did);
			
			
			List<DTypeVO> listType = new ArrayList<DTypeVO>();
			ResultSet rs = pre.executeQuery();
			
			while(rs.next()){
				DTypeVO typeVO = new DTypeVO();
				typeVO.setId(rs.getInt("id"));
				typeVO.setTname(rs.getString("tname"));
				listType.add(typeVO);
			}
			String msg = JSON.toJSONString(listType);
			
			
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter pw = resp.getWriter();
			
			pw.write(msg);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
