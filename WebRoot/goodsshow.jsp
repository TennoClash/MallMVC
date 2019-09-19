<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>

.main tr{height:200px;} 
.main td{width:350px;}
.main{width:1445px;height:680px;} 
ul,li,ol{
	list-style:none;
}
a{
	text-decoration:none
	}
.clear{
	height::0px;
	line-height:0px;;
	font-size:0px;
	overflow:hidden;
	clear:both;
	}
	li{
	width:350px;
    height:200px;
	overflow:hidden;
	float:left;
	margin-left:30px;
	position:relative;
	margin-top:20px;
	display:inline-block;
	}
.name{
	width: 350px;
	height: 40px;
	background: #000;
	color: #fff;
	opacity: 0.5;
	filter: alpha(opacity=50);
	position: absolute;
	bottom: 0px;
	left: 0px;
	line-height: 40px;
	text-align: center;
	font-size:22px;
	font-weight: bold;
	}
	.introduce{
	width: 350px;
	height: 200px;
	background: #000;
	position: absolute;
	top: 0px;
	opacity: 0.5;
	filter: alpha(opacity=50);
	display: none;
	color: #FFF;
	text-align: center;
	font-weight: bold;
	transition:0.5;
	}
	a:hover .name{
	display:none;
	}
    a:hover .introduce{
	display:block;
	}
	.last{width:1500px;height:50px;margin-top:20px;font-size:22px;
	font-weight: bold;color:#fff;float:left;display:inline-block;}
	form{display:inline-block;}
	
</style>

</head>

<body>




<form name="condition" action="GoodsShowServlet" method="post">

商品名:<input type="text" name="good_name"/>
<input  type="submit" value="提交">

</form>

<div style="width:1700px;  height: 250px;">
<ul class="img">
<c:forEach items="${goodsList}" var="g">
          <li>
              <a href="QueryGoodsServlet?good_id=${g.good_id}&username=${username}" title="右转剁手">
                <img src="${g.good_pic}" width="350" height="200">
                <span class="name">${g.good_name }---${g.good_price}￥</span>
                <span class="introduce"> ${g.good_desc}  <br><br> 点击购买${username}<<</br></br>
                </span>
              </a>
          </li>
 </c:forEach>         
</ul> 
</div>
<div class="last">
  共${pageCount}页,当前第${page}页
				<a href="GoodsShowServlet?page=1&&good_name=${good_name}">首页</a>
				<c:choose>
					<c:when test="${page-1==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="GoodsShowServlet?page=${page-1}&&good_name=${good_name}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="GoodsShowServlet?page=${page+1}&&good_name=${good_name}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="GoodsShowServlet?page=${pageCount}&&good_name=${good_name}">末页</a>
<form action="GoodsShowServlet" method="post">
				    <input type="hidden" name="ttpage" value="${pageCount}">
				    <input type="text" name="tpage"/>
				    <input type="submit" value="跳转"/>
				</form>	
</div>


</body>
</html>