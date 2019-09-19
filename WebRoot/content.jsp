<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
*{margin:0;padding:0;}
ul,li,ol{list-style:none;}
.changeimg{
	height:600px;
	width:1025px;
	margin-left:auto;
	margin-right:auto;
	margin-top:50px;}
.bigimg{
	width:700px;
	height:400px;
	}

.smallimg{
	width:1050px;
	height:180px;
}
.smallimg ul li{
	width:315px;
	height:180px;
	float:left;
	margin-left:40px;
	margin-top:10px;
	transition:all 0.3s;
	}
.smallimg ul li:nth-child(1){
	margin-left:0px;}
.smallimg ul li img{
	border-radius:20px;}
.smallimg2{
	width:325px;
	height:400px;
	float:right;
	margin-top:-590px;
	}
.smallimg2 ul li{
	position:relative;}
.smallimg2 ul li img{
	border-radius:20px;}
.name_1{
	width:315px;
	height:25px;
	background:#333;
	opacity: 0.8;
	filter: alpha(opacity=80);
	position:absolute;
	bottom:0px;
	right:0px;
	line-height:25px;
	font-size:20px;
	font-weight:bold;
	color:#fff;
	text-align:center;
	border-radius:20px;
	}
.smallimg ul li{
	position:relative;}	
.name_2{
	width:315px;
	height:25px;
	background:#333;
	opacity: 0.8;
	filter: alpha(opacity=80);
	position:absolute;
	bottom:0px;
	right:0px;
	line-height:25px;
	font-size:20px;
	font-weight:bold;
	color:#fff;
	text-align:center;
	border-radius:20px;
	}
.smallimg ul li:hover{
	transform:scale(1.2,1.2);}
.smallimg2 ul li:hover{
	transform:scale(1.2,1.2);}
.smallimg2 ul li{
	width:315px;
	height:180px;
	margin-left:10px;
	margin-top:20px;
	transition:all 0.3s;}
.smallimg2 ul li:nth-child(1){
	margin-top:0;}
.changeimg2{
	height:600px;
	width:1025px;
	margin-left:auto;
	margin-right:auto;
	}
.bigimg2{
	width:700px;
	height:400px;
	float:right;
	}
.smallimg_2{
	width:1050px;
	height:180px;
	float:left;}
.smallimg_2 ul li img{
	border-radius:20px;}
.smallimg2_2 ul li{
	position:relative;}
.smallimg2_2 ul li img{
	border-radius:20px;}
.name_3{
	width:315px;
	height:25px;
	background:#333;
	opacity: 0.8;
	filter: alpha(opacity=80);
	position:absolute;
	bottom:0px;
	right:0px;
	line-height:25px;
	font-size:20px;
	font-weight:bold;
	color:#fff;
	text-align:center;
	border-radius:20px;
	}
.smallimg_2 ul li{
	position:relative;}
.name_4{
	width:315px;
	height:25px;
	background:#333;
	opacity: 0.8;
	filter: alpha(opacity=80);
	position:absolute;
	bottom:0px;
	right:0px;
	line-height:25px;
	font-size:20px;
	font-weight:bold;
	color:#fff;
	text-align:center;
	border-radius:20px;
	}
.smallimg_2 ul li{
	width:315px;
	height:180px;
	float:left;
	margin-left:40px;
	margin-top:10px;
	transition:all 0.3s;
	}
.smallimg_2 ul li:hover{
	transform:scale(1.2,1.2);}
.smallimg2_2 ul li:hover{
	transform:scale(1.2,1.2);}
.smallimg_2 ul li:nth-child(1){
	margin-left:0px;}
.smallimg2_2{
	width:325px;
	height:400px;
	float:left;
	margin-top:-580px;}
.smallimg2_2 ul li{
	width:315px;
	height:180px;
	margin-top:20px;
	transition:all 0.3s;}
.smallimg2_2 ul li:nth-child(1){
	margin-top:0px;}
	</style>

<title>Insert title here</title>
<script type="text/javascript" src="./js/tab.js">
var i=0; 
var timer=2000; 
var stopimg=true;</script>
</head>
<body>
<div class="changeimg">
        <div class="bigimg">
        <img id="bigimg" src="img/big1.jpg" width="700" height="400">
        </div>
        <script>
var picture=new Array(); 
picture[0]="big1.jpg"; 
picture[1]="big2.jpg"; 
picture[2]="big3.jpg"; 
picture[3]="big4.jpg"; 
picture[4]="big5.jpg"; 
        </script>        
        <div class="smallimg">
        <ul>
        <li><img onMouseOver="tabfun(2)" onMouseOut="continueimg()" src="img/small3.jpg" width="315" height="180">
        <span class="name_2">跑步鞋 ￥200 
        
        </span>
        </li>
        <li><img onMouseOver="tabfun(3)" onMouseOut="continueimg()" src="img/small4.jpg" width="315" height="180">
        <span id="division" class="name_2">登山鞋￥-339 
        
        </span></li>
        <li><img onMouseOver="tabfun(4)" onMouseOut="continueimg()" src="img/small5.jpg" width="315" height="180">
        <span class="name_2">夏季短裤 ￥200 
        
        </span></li>
        </ul>
        </div>
        
        <div class="smallimg2">
        <ul>
        <li class="s1"><img onMouseOver="tabfun(0)" onMouseOut="continueimg()" src="img/small1.jpg" width="315" height="180">
        <span class="name_1">耐克大促销 ￥200</span>      
        </li>
        <li class="s2"><img onMouseOver="tabfun(1)" onMouseOut="continueimg()" src="img/small2.jpg" width="315" height="180">
        <span class="name_1">跑到死 ￥199
        
        </span>
        </li>
        </div>
        </ul>
        
    
     </div>
     
     <div class="changeimg2">
        <div class="bigimg2">
        <img id="bigimg2" src="img/big1_2.jpg" width="700" height="400">
        </div>
         <script>
var picture2=new Array(); 
picture2[0]="big1_2.jpg"; 
picture2[1]="big2_2.jpg"; 
picture2[2]="big3_2.jpg"; 
picture2[3]="big4_2.jpg"; 
picture2[4]="big5_2.jpg"; 
          </script>

     
        <div class="smallimg_2">
        <ul>
        <li><img onMouseOver="tabfun2(2)" onMouseOut="continueimg2()" src="img/small3_2.jpg" width="315" height="180">
        <span class="name_4">跑步鞋 ￥395 
        
        </span>
        </li>
        <li><img onMouseOver="tabfun2(3)" onMouseOut="continueimg2()" src="img/small4_2.jpg" width="315" height="180">
        <span class="name_4">OPPO r9s ￥3000
        
        </span>
        </li>
        <li><img onMouseOver="tabfun2(4)" onMouseOut="continueimg2()" src="img/small5_2.jpg" width="315" height="180">
        <span class="name_4">原谅帽￥200 
        </span>
        </li>
        </ul>
        </div>
        
        <div class="smallimg2_2">
        <ul>
        <li><img onMouseOver="tabfun2(0)" onMouseOut="continueimg2()" src="img/small1_2.jpg" width="315" height="180">
        <span class="name_3">去年的表 ￥30 
        
        </span></li>
        <li><img onMouseOver="tabfun2(1)" onMouseOut="continueimg2()" src="img/small2_2.jpg" width="315" height="180">
        <span class="name_3">包 ￥240 </span></li>
        </ul>
     </div>
     </div>
     
</body>
</html>