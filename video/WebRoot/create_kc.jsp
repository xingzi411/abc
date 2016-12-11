<%@page import="com.video.vo.DTypeVO"%>
<%@page import="com.video.vo.DirectionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/global_style.css" type="text/css" />
<script type="text/javascript">
	window.onload = function(){
		var dire = document.getElementById("dire");
		dire.onchange = function(){
			var httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange = function(){
				if(httpRequest.readyState == 4){
					//获取响应的数据
					var data = httpRequest.responseText;
					document.getElementById("sp").innerText = data;
					//将数据格式进行转换
					var obj = eval("("+data+")");
					
					
					//对数据的处理方式
					var t_kc = document.getElementById("t_kc");
					t_kc.innerHTML = "";
					for(var attr in obj){
						var o = obj[attr];
						var op = document.createElement("option");
						op.innerHTML = o.tname;
						op.value =o.id;
						
						t_kc.appendChild(op);
					}
					
					
					
				}
			}
			httpRequest.open("POST","findType.do?did="+this.value, true);
			httpRequest.send(null);
		}
	}
</script>
</head>

<body>
	
		<span id="sp" style="font-size:40px"></span>
	
	
	
		<div class="main_right_top">订单管理 > <span>全部订单</span></div>
		<div class="main_right_body"> 
			<div class="creat_user">
				<ul>
					<li>
						<label>课程方向：</label>
						<select id="dire">
							<option>----请选择----</option>
							<%
							List<DirectionVO> list = (List<DirectionVO>)request.getAttribute("listDire");
							for(int i=0;i<list.size();i++){
								%>
									<option value="<%=list.get(i).getId()%>"><%=list.get(i).getDirection() %></option>
							 <% } %>
						</select>	
					</li>
					<li>
						<label>课程类型：</label>
						<select id="t_kc">
							
						</select>	
					</li>
					<li>
						<label>课程名称：</label>
						<input type="text" />					
					</li>
					<li>
						<label>作者：</label>
						<input type="text" />					
					</li>
					
					<li>
						<label>课程说明：</label>
						<textarea class="textarea_min"></textarea>						
					</li>
					<li>
						<label>上传图片：</label>
						<div class="online_img">
							<!-- <div class="book_img">
								<img src="images/one.jpg">
								<a class="book_img_delete"></a>
							</div> -->
							<div class="gall_file_fold">
								  <input type="button" id="" value="点击上传图片" class="galleries_chose">
								  <input type="file" class="jquploader">
							 </div>
						</div>	
					</li>	
				</ul>	
			</div><!--creat_user-->
			<div class="regist_btn">
				<input type="submit" value="提交" />
				<a class="return_btn">返回</a>
			</div>		
		</div> <!--main_right_body-->
	
</body>
</html>
