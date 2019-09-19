<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>
*{margin:0;padding:0;}
ul,li,ol{list-style:none;}
body{background:#333;
	}
a{text-decoration:none;	font-weight:bold;color:#f00;}
#title{width:200px;height:30px;margin-left:auto;margin-right:auto;font-weight:bold;color:#f55b1f;
font-size: 30px;text-align: center;}
#con{width:200px;height:20px;float:left;font-weight:bold;color:#fff}
.uu{width:250px;height:20px;color:#004EB1}
.nav{width:1000px;height:100px;margin-left:auto;margin-right:auto;margin-top:20px;}
.nav span:nth-child(1){margin-left:200px;}
.nav span:nth-child(4){border-right:0px solid #FFF;}
.nav span{
	width:150px;
	height:30px;
	border-right:2px solid #FFF;
	float:left;
	line-height:30px;
	color:#FFF;
	text-align:center;
	transition:all 0.3s;	}
.nav span ul a{color:#fff}
.nav span ul a:hover{
	color:#0C3;}
.nav span:hover{
	background:#CCC;
	opacity: 1;
	filter: alpha(opacity=100);}
	.nav span ul{
	display:none;
		transition:all 0.5s;
	}
.nav span:hover ul{
	display:block;
	background:#666;
	}
</style>
</head>
<body>

<div id="title">
购物网站
</div>
<div id="con">

	<c:if test="${user!=null}">
		欢迎${user.username}<a class="login" href="LogoutServlet">    注销</a>
	</c:if>
	<c:if test="${user==null}">
     <a class="login" href="login.jsp" target="index">点击登录</a>
     <div class="uu">还没有帐号？
     <a href="register.jsp" target="index">点击注册一个</a>
     </div>
</c:if>
</div>

<div class="nav">
<span>用户管理
<ul>
<li><a href="QueryUserServlet" target="content">用户查询</a></li>
<c:if test="${user.user_type=='管理员'}">
<li><a href="changepwd.jsp" target="content">用户修改</a></li>
</c:if>
</ul>
</span>

<span>
订单管理
<ul>
<li><a href="QueryOrderServlet" target="content">订单查询</a></li>
</ul>
</span>

<span>
购物车管理
<ul>
<li><a href="QueryShoppingCartServlet?username=${user.username }" target="content">我的购物车</a></li>
</ul>
</span>

<span>
商城
<ul>
<li><a href="index.jsp" target="index">首页推荐</a></li>
<li><a href="GoodsShowServlet?user_name=${user.username}" target="content">商城主页</a></li>
</ul>
</span>


</div>
</body>
</html>