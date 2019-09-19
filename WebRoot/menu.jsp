<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
a{text-decoration:none;color:#0095ff}
span{font-weight:bold;}
.clock{height:113.5px;width:113.5px;margin-left:auto;margin-right:auto;position:relative;}
#fenzhen{position:absolute;top:0px;right:50%;margin-right:-2.76px;margin-top:8.5px;transform-origin:bottom;}
#shizhen{position:absolute;top:0px;right:50%;margin-right:-3.5px;margin-top:22px;transform-origin:bottom;}
#miaozhen{position:absolute;top:24px;right:50%;margin-right:-2px;transform-origin:center 67.5%;}
#date1{width:200px;height:40px;margin-left:auto;margin-right:auto;color:#f00;font-weight:bold;
font-size:18px;overflow:hidden;text-align: center;}
span{color:#f55b1f;}
</style>

<script type="text/javascript" src="./js/clock.js"></script>
<title>Insert title here</title>
</head>
<body>

<div class="clock">
              <img id="biaopan" src="img/clock/clock.png" width="113.5" height="113.5">
              <img id="shizhen" src="img/clock/shizhen.png" width="4.25" height="36.75">
              <img id="fenzhen" src="img/clock/fenzhen.png" width="3.5" height="50">
              <img id="miaozhen" src="img/clock/miaozhen.png" width="2.25" height="48.75">
              </div>
              <div id="date1">
              获取时间出错
              </div>
              
              
<div class="admin">
<c:if test="${user.user_type=='管理员'}">
<span>商城管理
<ul>

<li><a href="goodsadd.jsp" target="content">商品添加</a></li>
<li><a href="QueryOrderServlet" target="content">订单查询</a></li>
</ul>
</span>
</c:if>
</div>

</body>
</html>