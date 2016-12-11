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
		var user = document.getElementById("user");
		var pass = document.getElementById("pass");
		var sp1 = document.getElementById("sp1");
		user.onfocus = function(){
			sp1.style.display = "none";
		}
		
		user.onblur = function(){
			if(this.value){
				return ;
			}
			sp1.removeAttribute("style");
		}
		
		//客户端数据校验
		document.forms[0].onsubmit = function(){
			
			var login_error = document.getElementById("login_error");
			if(!user.value){
				login_error.innerText = "用户名不能为空";
				return false;
			}
			
			if(!pass.value){
				login_error.innerText = "密码不能为空";
				return false;
			}
			
		}
		
		
	}
	
</script>


</head>

<body style="background-color:#16aabd; ">
	<div class="login_all">
	  	<div class="login_all_content">
			<div class="login_head">
				<h1>视频播放系统后台管理</h1>
			</div>
			<div class="login_center">
			<form action="login.do" method="post" id="login_form">
				<div class="login_center_content">
					<div class="login_name">
						<label>用户名：</label>
						<div class="password_text">
							<span class="write_word" id="sp1">请输入用户名</span>
							<input type="text" name="user" id="user"/>
						</div>
						<div class="clr"></div>
					</div>
					<div class="login_error" id="login_error">
						<%=request.getAttribute("error")==null?"":request.getAttribute("error") %>
					</div>
					<div class="password_name">
						<label>密码：</label>
						<div class="password_text">
							<span class="write_word" >请输入密码</span>
							<input type="password" name="pass" id="pass"/>
						</div>
						<div class="clr"></div>
					</div>
					<input type="submit" class="login_button" value="&nbsp;" id="a_sub"/>
				</div>	
				</form>
			</div><!--login_center-->
			<div class="login_bottom"></div>		
		</div><!--login_all_content-->
	</div><!--login_all-->
</body>
</html>