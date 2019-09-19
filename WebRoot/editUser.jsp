<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title her</title>
<style type="text/css">
html{background:url("img/back-1.jpg");background-repeat: repeat-x-y;}
tr,td{color:#fff}
	div{ margin: 100px auto 0; width: 360px}
	input[type='text'],textarea{width:99%}
	.tdlast{text-align: center;padding: 10px 0}
#re{color:#f55b1f;font-size: 30px ;font-weight:bold;}
#sex{color:#fff}
form{color:#fff}
</style>
</head>
<body>
<form action="UpdateUserServlet" method="post" name="updataForm">
<input type="hidden" name="change" value="update"/>
<input type="hidden" name="user_id" value="${n.user_id}"/>
	<div>
	<table>
		<tr>
			<td id="re" colspan="4" class="tdfirst">修改用户信息</td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" name="username" id="username" value="${n.username}" disabled="true"/></td>
		</tr>
		<tr>
			<td><input type="password" name="password" id="password"  value="密码不可修改" disabled="true"/></td>
			<td><input type="password" name="repassword" id="repassword" disabled="true"/></td>
		</tr>
		<tr id="sex">
			<td>性别</td>
			<td>
				<input type="radio" name="gender" id="male" value="male" <c:if test="${n.gender=='male'}"> checked='checked'</c:if> />男
				<input type="radio" name="gender" id="male" value="female" <c:if test="${n.gender=='female'}"> checked='checked'</c:if> />女
			</td>
		</tr>
		<tr>
			
			<td><input type="text" name="email" id="email" value="${n.email }" /></td>
			<td><input type="text" name="realname" value="${n.realname }" id="realname" /></td>
		</tr>
		<tr>
		<td colspan="2" ><input type="text" name="phone" value="${n.phone }" id="phone"/></td>
		</tr>
		<tr>
			<td colspan="4" class="tdlast">
			 <span class="admin">是否为管理员
			    <input type="radio" name="user_type" value="user" checked>否
			    <input type="radio" name="user_type" value="admin">是
			    </span> 
				<input type="submit" value="提交" />
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
</body>
</html>