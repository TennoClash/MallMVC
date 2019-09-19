<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
<style type="text/css">
    html{background:url("img/back-1.jpg");background-repeat: repeat-x-y;}
	div{ margin: 100px auto 0; width: 300px}
	input[type='text'],input[type='password']{width: 99%}
	.errors{border: 1px solid black; color: red}
	#lo{color:#f55b1f;font-size: 30px ;font-weight:bold;}
</style>
<script type="text/javascript">
	window.onload = function(){
		var regBtn = document.getElementById("regBtn");
		regBtn.onclick = function(){
			window.location.href = "register.jsp";
		}
	}
</script>
</head>
<body>
<form action="LoginServlet" method="post">
	<div>
	
	<c:if test="${error!=null}">
	<div class="errors">
		${error}
	</div>
	</c:if>
	
	<table>
		<tr>
			<td id="lo" colspan="4" class="tdfirst">用户登陆</td>
		</tr>
		<tr>
			<td colspan="3"><input type="text" name="username" id="username" placeholder="用户名"/></td>
		</tr>
		<tr>
			<td  colspan="3"><input type="password" name="password" id="password" placeholder="密码"/></td>
		</tr>
		<tr>
			<td colspan="4" class="tdlast">
				<input type="submit" value="提交"/>
				<input type="reset" value="重置"/>
				<input type="button" value="注册" id="regBtn"/>
			</td>
		</tr>
	</table>
	
	</div>
	</form>
</body>
</html>