<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style>

td{ border: 1px solid white;}
.all2{border:0px;}
ul,li,ol{
	list-style:none;
}
a{
	text-decoration:none
	}
	.last{font-size:22px;
	font-weight: bold;color:#fff;float:left;display:inline-block;}
	form{display:inline-block;}
	.all{color:#fff;font-weight: bold;font-size:22px;}
</style>

</head>
<body>
<div class="all">
我的购物车
<table class="all2">

<tr>

<td colspan="7">
<form name="condition" action="QueryShoppingCartServlet?username=${username }" method="post">
商品名:<input type="text" name="good_name"/>
<input  type="submit" value="搜索">
</form>
</td>
</tr>
<form name="condition" action="AddOrderServlet?username=${username }" method="post">

<table>
<tr>
<td>图片</td>
<td>订单编号</td>
<td>用户名</td>
<td>商品名</td>
<td>数量</td>
<td>总价格</td>
<td>操作</td>

</tr>

<c:forEach items="${cratList}" var="u">
<input type="hidden" name="sc_id" value="${u.sc_id }" />
<input type="hidden" name="order_price" value="${u.good_price*u.sc_count}" />



					<tr>
					<td> <img src="${u.good_pic}" width="175" height="100"></td>
						<td>${u.sc_id }</td>
						<td>${u.username }</td>
						<td>${u.good_name }</td>
						<td>${u.sc_count }</td>
						<td>${u.good_price*u.sc_count}</td>
						<td><a href="DeleteCartServlet?sc_id=${u.sc_id }">删除</a></td>
</tr>
</c:forEach>
<input type="submit" value="提交订单">
</form>
<tr>
					    <td colspan="7">
					    
					    </table> 
<div class="last">
                                             共${pageCount}页,当前第${page}页
				<a href="QueryShoppingCartServlet?page=1&&username=${username}">首页</a>
				<c:choose>
					<c:when test="${page-1==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="QueryShoppingCartServlet?page=${page-1}&&username=${username}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="QueryShoppingCartServlet?page=${page+1}&&username=${username}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="QueryShoppingCartServlet?page=${pageCount}&&username=${username}">末页</a>
				
				
				
				<form action="QueryShoppingCartServlet?username=${username }" method="post">
				    <input type="hidden" name="ttpage" value="${pageCount}">
				    <input type="text" name="tpage"/>
				    <input type="submit" value="跳转"/>
				</form>	
					    
					    </td>
					</tr>


</div>

</div>

</table>

</body>
</html>