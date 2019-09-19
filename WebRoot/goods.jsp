shoppingcartdao<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<title>Insert title here</title>
<style>
.all{width:1000px;height:600px;background:#fff;opacity:0.8;}
.all2{width:1000px;height:600px;position:relative;margin-top:-600px;}

.name{width:580px;height:30px;font-size: 16px;font-weight: 900;line-height: 30px;float:right;background:#FFF2E8;}
.dec{width:580px;height:60px;font-size: 16px;font-weight: 900;line-height: 30px;float:right;margin-top:-210px;background:#FFF2E8;border-bottom:solid 2px}
.price{width:580px;height:60px;font-size: 14px;font-weight: 900;line-height: 30px;float:right;background:#FFF2E8;margin-top:-150px;color:#F00}
.pic{position:relative;}
.tuijian{position:relative;width:100px;height:100px;margin-left: 880px;margin-top:-240px;}
.gouwuche{width:580px;height:90px;font-size: 16px;font-weight: 900;line-height: 90px;float:right;background:#FFF2E8;margin-top:-90px}
.gpic{margin-top:20px}
form{display:inline-block;}
</style>
<script type="text/javascript">

function f(){
	document.getElementById("formid").submit();

}
</script>

</head>
<body>
<div class="all"></div>
<div class="all2">
<span class="pic" >
 <img src="${good_pic}" width="420" height="240">
</span>

   <div class="name">
   ${good_name }
   </div>
   
   <div class="dec">
   ${good_desc}
   </div>
   
   
   
   
   <div class="price">
   价格:￥<s>${good_price}</s>
   &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 库存数量:${qty }&nbsp&nbsp 生产厂家:${ supplier}
    <br>
    优惠价:￥${bprice }
     </div>
    
   <div class="gouwuche">

<form  id="formid" action="AddShoppingCartServlet" method="post">	

<input type="hidden" value="${good_name}" name="good_name"/>
<input type="hidden" value="${good_pic}" name="good_pic"/>
<input type="hidden" value="${username}" name="username"/>	
<input type="hidden" value="${good_price}" name="good_price"/>		
			
数量<input type="text" name="sc_count"/>
<img  class="gpic"  src="img/gouwuche.png" Onclick="f()" width="200" height="46">
</form>	
   </div>
    
    
    
     <c:if test="${ispreferred=='yes'}">
    <img  class="tuijian" src="img/ispreferred.png" width="100" height="100">
    </c:if>
    
<CENTER><FONT face=隶书 color=red size=15> <MARQUEE direction=up behavior=alternate width=60 height=120>欢</MARQUEE>
<FONT color=yellow> <MARQUEE direction=up behavior=alternate width=60 height=80>迎</MARQUEE>
<FONT color=brown> <MARQUEE direction=up behavior=alternate width=60 height=120>购</MARQUEE>
<FONT color=green> <MARQUEE direction=up behavior=alternate width=60 height=80>买</MARQUEE>
</FONT></B></FONT></CENTER></FONT></FONT></FONT>
</div>


</body>
</html>