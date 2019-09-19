<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.tdfirst{ background-image: url("img/table_title_mid.gif");background-repeat: repeat-x;}
table{ border: 1px solid black;width: 99%}
	td{ border: 1px solid black}
	form{display:inline-block;}
</style>
<title>Insert title here</title>

</head>
<body>

<table>
<tr>
	
<td colspan="7" class="tdfirst" >用户查询</td>

</tr>

<tr>
<td colspan="7">


<form name="condition" action="QueryUserServlet" method="post">

用户名:<input type="text" name="username"/>
<input  type="submit" value="提交">
</form>
</td>
</tr>


<tr>
			<td>
				<table>

<tr>
<td>用户编号</td>
<td>用户名</td>
<td>邮箱</td>
<td>性别</td>
<td>电话</td>
<td>用户类型</td>
<td>操作</td>
</tr>

                    <c:forEach items="${userList}" var="u">
					<tr>
						<td>${u.user_id }</td>
						<td>${u.username }</td>
						<td>${u.email }</td>
						<td>${u.gender }</td>
						<td>${u.phone }</td>
						<td>${u.user_type}</td>
						
						<td>
						<c:if test="${u.user_type!='管理员'||user.user_id == u.user_id }">
					        <a href="UpdateUserServlet?user_id=${u.user_id}&&change=display">修改</a>
							<a href="DeleteUserServlet?user_id=${u.user_id}">删除</a>
							</c:if>
						</td>
					</tr>
					</c:forEach>
					
					
					<tr>
					    <td colspan="7">
					    
					    </table>
					    共${pageCount}页,当前第${page}页
				<a href="QueryUserServlet?page=1&&username=${username}">首页</a>
				<c:choose>
					<c:when test="${page-1==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="QueryUserServlet?page=${page-1}&&username=${username}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="QueryUserServlet?page=${page+1}&&username=${username}">下一页</a>
					</c:otherwise>
				</c:choose>
				<a href="QueryUserServlet?page=${pageCount}&&username=${username}">末页</a>
				
				
				
				<form action="QueryUserServlet" method="post">
				    <input type="hidden" name="ttpage" value="${pageCount}">
				    <input type="text" name="tpage"/>
				    <input type="submit" value="跳转"/>
				</form>	
					    
					    </td>
					</tr>

</table>


</body>
</html>