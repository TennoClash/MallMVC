<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style type="text/css">
html{background:url("img/back-1.jpg");background-repeat: repeat-x-y;}
	div{ margin: 100px auto 0; width: 360px}
	input[type='text'],textarea{width:99%}
	.tdlast{text-align: center;padding: 10px 0}
#re{color:#f55b1f;font-size: 30px ;font-weight:bold;}
#sex{color:#fff}
</style>
<script type="text/javascript" src="./js/reg.js"></script>
</head>
<body>
<form action="RegisterServlet" method="post" name="registerForm" >
	<div>
	<table>
		<tr>
			<td id="re" colspan="4" class="tdfirst">新用户注册</td>
		</tr>
		<tr>
			<td colspan="2"><input type="text" name="username" id="username" placeholder="用户名"/></td>
		</tr>
		<tr>
			<td><input type="password" name="password" id="password" placeholder="密码"/></td>
			<td><input type="password" name="repassword" id="repassword" placeholder="确认密码"/></td>
		</tr>
		<tr id="sex">
			<td>性别</td>
			<td>
				<input type="radio" name="gender" value="male" checked/>男
				<input type="radio" name="gender" value="famale"/>女
			</td>
		</tr>
		<tr>
			
			<td><input type="text" name="email" id="email" placeholder="email"/></td>
			<td><input type="text" name="realname" id="realname" placeholder="realname"/></td>
		</tr>
		<tr>
		<td colspan="2" ><input type="text" name="phone" id="phone" placeholder="phone"/></td>
		</tr>
		<tr>
			<td colspan="4" class="tdlast">
			    <input type="hidden" name="adminadd" value="no">
			    <input type="hidden" name="admintype" value="user"> 
				<input type="button" value="提交" onclick="checkReg()"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
</body>
</html>