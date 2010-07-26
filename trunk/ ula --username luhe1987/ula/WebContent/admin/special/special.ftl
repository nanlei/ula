<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="${base}/css/about.css" rel="stylesheet" type="text/css" />
<!--<script type="text/javascript" src="${base}/js/jquery-1.4.1.min.js"></script>
<script type="text/javascript" src="${base}/js/jquery.jcarousel.pack.js"></script>
<script type="text/javascript" src="${base}/js/jquery-func.js"></script>-->
<script type="text/javascript" src="${base}/js/menu.js"></script>
</head>
<script language=javascript>  
 function my_height(){
	var my_right = document.getElementById("main_right");
	var my_left = document.getElementById("left_menu");
	my_left.style.height= my_right.clientHeight + "px";
}   
</script>  

</head>
<body onload= "my_height()">

<#include "../../global/header.html">

<div id="main">
 <div id="left_menu">
  <ul class="rolinList" id="rolin">
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/special/visa!view.action">签证</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/reservation/hotel_reservation.html">宾馆预订</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
  <li>
  	<div class="menu_title">
    <h2>委托</h2>
    </div>
    <div class="content">
    	<div class="content_item"><a href="${base}/special/ticket!view.action">代订车、船票</a></div>
        <div class="content_item"><a href="${base}/special/carrental!view.action">租车服务</a></div>
        <div class="content_item"><a href="${base}/special/translation!view.action">翻译服务</a></div>
        <div class="content_item"><a href="${base}/special/souvenir!view.action">代邮寄纪念品</a></div>
    </div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/special/russianstudents!view.action">俄罗斯留学生</a></h2>
    </div>
    <div class="content" style="height:1px;"></div>
  </li>
</ul>
  </div>
  
  
    <div id="main_right">
    
    
  	<div class="right_title">
    	<h3>>>${view.title}</h3>
    </div>
    
    <div class="right_content">
    
     <p class="content_p">${view.content}</p>
    
    </div> 
    
  </div>

<#include "../../global/footer.html">

</body>
</html>
