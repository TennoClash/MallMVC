function checkReg(){
	
	//console.log("测试");
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var repassword = document.getElementById("repassword");
	
	if(username.value==null||username.value==""){
		alert("用户名不能为空");
		return;
	}
	
	if(password.value.length<6){
		alert("密码长度不能小于6");
		return;
	}
	
	if(password.value!=repassword.value){
		alert("密码不一致");
		return;
	}
	
	document.registerForm.submit();
	
	
	
}