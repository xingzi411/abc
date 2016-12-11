package com.video.server;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class Upload extends HttpServlet{
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		 DiskFileItemFactory factory = new DiskFileItemFactory();  
	        @SuppressWarnings("deprecation")  
	        String path = request.getRealPath("");//设置磁盘缓冲路径  
	      
	        factory.setRepository(new File(path));  
	        factory.setSizeThreshold(1024*1024);//设置创建缓冲大小  
	          
	        ServletFileUpload upload = new ServletFileUpload(factory);  
	        upload.setSizeMax(-1);//设置上传文件限制大小,-1无上限  
	        try {  
	            @SuppressWarnings("unchecked")  
	            List<FileItem> list = upload.parseRequest(request);
	            String va = null;  
	            for(FileItem item : list){  
	                if(item.isFormField()){//判断是否是文件流  
	                    va = item.getString("UTF-8");  
	                    System.out.println(va);
	                }else{  
	                    item.write(new File("d:/a.png"));
	                }  
	            }  
	        } catch (Exception e) {  
	              
	            e.printStackTrace();  
	        }  
	}
	
	
	public static void main(String[] args) {
		
	}
	
	
}
