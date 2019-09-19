var i=0; 
var timer=2000; 
var stopimg=true;
function tabfun(img){
	var bigimg=document.getElementById("bigimg");
var i=img;  
bigimg.src="img/"+picture[i];
stopimg=false;
	 }

function continueimg(){
	stopimg=true;
	}

function changeimg() { 
if(stopimg){
var bigimg1=document.getElementById("bigimg"); 
if(i==picture.length-1) 
{i=0;} 
else {i++;} 
bigimg1.src="img/"+picture[i]; 
} 
}
setInterval(changeimg,timer); 
//*-*-*-*-*-*-*-*-*-*-*-*-*-*
var k=0;
var stopimg2=true;
function tabfun2(img){
var bigimg2=document.getElementById("bigimg2");
var k=img;  
bigimg2.src="img/"+picture2[k];
stopimg2=false;
	 }

function continueimg2(){
	stopimg2=true;
	}

function changeimg2() { 
if(stopimg2){
var bigimg2_2=document.getElementById("bigimg2"); 
if(k==picture.length-1) 
{k=0;} 
else {k++;} 
bigimg2_2.src="img/"+picture2[k]; 
} 
}
setInterval(changeimg2,timer);