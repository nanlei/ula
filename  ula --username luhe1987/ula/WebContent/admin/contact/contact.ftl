
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="${base}/css/about.css" rel="stylesheet" type="text/css" />
<link href="${base}/css/index.css" rel="stylesheet" type="text/css" />
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
    <h2><a href="${base}/contact/rugroup!view.action">俄罗斯团体</a></h2>
    </div>
    
  </li>
   <li>
  	<div class="menu_title">
    <h2><a href="${base}/contact/cngroup!view.action">中国团体</a></h2>
    </div>
    
  </li>
   <li>
  	<div class="menu_title">
    <h2><a href="${base}/contact/person!view.action">个人客户</a></h2>
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

</div>

<div id="links">
 <div id="link_left"></div>
 <div id="link_right">
 	<ul id="link_ul">
 	<#list link.list as aLink>
    	<li><a href="${aLink.url}">${aLink.title}</a></li>
    </#list>
    </ul>
 </div>
</div>
<div id="foot">
	<div id="Copyright"><span>Copyright © 2009 SOVO All Rights Reserved<br>
Powered By Pioneer</span></div>
</div>
</body>
</html>
