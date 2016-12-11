<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link rel="stylesheet" href="css/global_style.css" type="text/css" />
</head>

<body>
	<!--head-->
	<div id="head" class="main_top"> 
		 <div class="logopanel">
		 	<a>云思订房系统后台管理系统</a>
         </div><!--logopanel-->
		 <div class="headerpanel">
			 <div class="headerright">
			 	<p><span>用户名！</span>云思订房系统欢迎您！</p>
				<a class="edit_password" href="#"><img src="images/top_icon1.png" width="88" height="30" /></a>
				<a class="" href="#"><img src="images/top_icon2.png" width="88" height="30" /></a> 
				<div class="clr"></div>	
			 </div> 
			 <div class="clr"></div>
		  </div><!--headerpanel-->
		 <div class="clr"></div>	
	</div>
	<!--head结束-->
	
	<!--main_left开始-->
	<div id="main_left">
		<div class="main_left_border">
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="user_list.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="home_icon">超级管理员</span>
						<div class="clr"></div>	
					</a>
					<!--二级目录-->
					<ul class="navmenu">
						<li>
							<a href="menu_manage.html"><span class="none_nav" >菜单管理</span></a>
						</li>
						<li>
							<a href="admin_manage.html"><span class="none_nav" >管理员管理</span></a>
						</li>
					</ul>
					<!--二级目录结束-->
				</li>
			</ul>			
			<!--一级目录-->
			<ul class="thirdmenu">
				<li>
					<a href="#"><span>系统管理员</span></a>
				</li>
				<li><a href="#"><span>系统操作员</span></a></li>
			</ul>		
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="user_list.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="home_icon">用户管理</span>
						<div class="clr"></div>	
					</a>
					<!--二级目录-->
					<ul class="navmenu">
						<li>
							<a href="user_list.html"><span class="none_nav" >用户列表</span></a>
						</li>
						<li class="navmenu_actvie">
							<a href="creat_user.html"><span class="none_nav" >创建用户</span></a>
						</li>
					</ul>
					<!--二级目录结束-->						
				</li>
			</ul>			
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="order_list.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="order_icon">订单管理</span>
						<div class="clr"></div>	
					</a>
					<!--二级目录-->
					<ul class="navmenu">
						<li>
							<a href="order_list.html"><span class="none_nav" >全部订单</span></a>
						</li>
						<li>
							<a href="#"><span class="none_nav" >历史订单</span></a>
						</li>
					</ul>
					<!--二级目录结束-->					
				</li>
			</ul><!--mainmenu-->
			
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="sta_manage.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="sat_icon">报表管理</span>
						<div class="clr"></div>	
					</a>				
				</li>
			</ul>			
			<!--一级目录-->
			<!--一级目录-->
			<ul class="mainmenu">
				<li > 
					<a href="hotel_list.html">
						<img src="images/next_icon.png" width="10" height="5"/>
						<span class="hotel_icon">酒店管理</span>
						<div class="clr"></div>	
					</a>				
				</li>
				<!--二级目录-->
					<ul class="navmenu">
						<li>
							<a href="hotel_list.html"><span class="none_nav" >酒店列表</span></a>
						</li>
						<li>
							<a href="creat_hotel.html"><span class="none_nav" >创建酒店</span></a>
						</li>
					</ul>
					<!--二级目录结束-->	
			</ul>			
			<!--一级目录-->
		</div>
	</div>
	<!--main_left结束-->
		
	<!--main_middle开始-->
	<div id="main_middle">
		<img id="left_on"  src="images/middle_btn1.png" width="8" height="60" />
		<img id="left_off" src="images/middle_btn2.png" width="8" height="60" style="display:none" />
	</div>
	<!--main_middle结束-->
		
	<!--main_right-->
	
	<div id="main_right"> 
		<div class="main_right_top">用户管理 > <span>创建用户</span></div>
		<form action="fx.do" method="post">
		<div class="main_right_body"> 
			<div class="creat_user">
				<ul>
					<li>
						<label>课程方向：</label>
						<input type="text" name="dire"/>				
					</li>
					<div class="base_error"><i></i></div>
				</ul>		
				<div class="regist_btn">
					<input type="submit" value="提交" />
					<a class="return_btn">返回</a>
				</div>		
			</div><!--creat_user-->
		</div> <!--main_right_body-->
		</form>
	</div><!--main_right结束-->
	
</body>
</html>
