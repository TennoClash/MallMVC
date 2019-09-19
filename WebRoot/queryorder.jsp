<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<style>
form,td,tr{color:#fff;font-size:20px;font-weight:bold}
</style>

<body>

<table>
<tr>
	
<td colspan="7" class="tdfirst" >用户查询</td>

</tr>

<tr>
<td colspan="7">


<form name="condition" action="QueryOrderServlet" method="post">

用户名:<input type="text" name="username"/>
<input  type="submit" value="提交">
</form>
</td>
</tr>


<tr>
			<td>
				<table>

<tr>
<td>订单编号</td>
<td>用户名</td>
<td>提交日期</td>
<td>购物车编号</td>
<td>价格</td>

</tr>

                    <c:forEach items="${orderList}" var="u">
					<tr>
						<td>${u.order_id}</td>
						<td>${u.username }</td>
						<td>${u.order_date }</td>
						<td>${u.sc_id }</td>
						<td>${u.order_price }</td>
				
						
						
						
					</tr>
					</c:forEach>
					
					
					<tr>
					    <td colspan="7">
					    
					    </table>
					    共${pageCount}页,当前第${page}页
				<a href="QueryOrderServlet?page=1&&username=${username}">首页</a>
				<c:choose>
					<c:when test="${page-1==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="QueryOrderServlet?page=${page-1}&&username=${username}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="QueryOrderServlet?page=${page+1}&&username=${username}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="QueryOrderServlet?page=${pageCount}&&username=${username}">末页</a>
				
				
				
				<form action="QueryOrderServlet?username=${username }" method="post">
				    <input type="hidden" name="ttpage" value="${pageCount}">
				    <input type="text" name="tpage"/>
				    <input type="submit" value="跳转"/>
				</form>	
					    
					    </td>
					</tr>

</table>


</body>
</html>