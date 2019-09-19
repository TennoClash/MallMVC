function colorchange()  
{  
    document.getElementById("title").style.color = getcolor();  
    }  

function getcolor()  
{  
    var mycolor = "#";  
    var color ="123456789abcdef";  
    var colorcode = color.split("");  
  
    for(var i=0;i<6;i++)  
    {  
        mycolor+=colorcode[Math.floor(15*Math.random())];         
    }  
    return mycolor;  
}  
setInterval("colorchange()",200);