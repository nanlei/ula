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
	if(my_left.clientHeight <= my_right.clientHeight){
	my_left.style.height= my_right.clientHeight + "px";
	}
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
    <h2><a href="${base}/program/recommend!view.action">本月推荐</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/regular!view.action">常规行程</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/therapy!view.action">治疗行程</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/chineselanguage!view.action">汉语学习</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/summercamp!view.action">夏令营行程</a></h2>
    </div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/hotspring!view.action">温泉游</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/exhibition!view.action">会展、展览</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/program/countryside!view.action">乡村游</a></h2>
    </div>
    
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
