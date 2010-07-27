
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="/ula/css/about.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/ula/js/menu.js"></script>

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
    <h2><a href="${base}/about/company!view.action">公司介绍</a></h2>
    </div> 
  </li>
  
   <li>
  	<div class="menu_title">
    <h2><a href="${base}/about/team!view.action">人员介绍</a></h2>
    </div>  
  </li>
  
   <li>
  	<div class="menu_title">
    <h2><a href="${base}/about/biz!view.action">业务范围</a></h2>
    </div>  
  </li>
  
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/about/memory!view.action">美好回忆</a></h2>
    </div>   
  </li>
  
</ul>
  </div>
  
  <div id="main_right">
  	<div class="right_title">
    	<h3>>>${view.title}</h3>
    </div>
    <div class="right_content">
     <p class="content_p"><#if view.content?exists>${view.content}</#if> </p>
    </div>
    
  </div>
  
</div>

<#include "../../global/footer.html">

</body>
</html>
