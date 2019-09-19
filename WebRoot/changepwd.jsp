<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<style>
td,tr,form{color:#fff;font-weight:bold;}

</style>
</head>
<body>
<form action="ChangePWDServlet" method="post" name="changePwdForm">
	<div>
	<table>
		<tr>
			<td colspan="4" class="tdfirst">密码修改</td>
		</tr>
		<tr>
			<td>原密码</td>
			<td colspan="3"><input type="password" name="password" id="password" required/>*</td>
		</tr>
		<tr>
			<td>新密码</td>
			<td><input type="password" name="npassword" id="npassword" required/>*</td>
			<td>确认密码</td>
			<td><input type="password" name="repassword" id="repassword" required/>*</td>
		</tr>
	
		<tr>
			<td colspan="4" class="tdlast">
				<input type="submit" value="提交" />
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
</body>
</html>