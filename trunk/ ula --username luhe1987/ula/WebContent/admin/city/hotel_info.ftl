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

<script language=javascript>  
  function my_height(){
	var my_right = document.getElementById("main_right");
	var my_left = document.getElementById("left_menu");
	if(my_left.clientHeight <= my_right.clientHeight){
	my_left.style.height= my_right.clientHeight + "px";
	}
}    
</script>  


<style type="text/css">
       

	#gallery {
		width:640px;
		height:650px;
		margin:0 auto;
		position:relative;
		font-family:verdana, arial, sans-serif;
	}
	
	#gallery a.previous {display:block; height:40px; width:32px; background:url(../click/previous.gif); position:absolute; left:0; top:560px;}
	#gallery a.next {display:block; height:40px; width:32px; background:url(../click/next.gif); position:absolute; right:0; top:560px;}
	#gallery a b {display:none;}
	#gallery #fullsize {
		position:absolute;
		left:0;
		top:0;
		height:800px;
		width:640px;
		overflow:hidden;
		text-align:center;
	}
	#gallery #fullsize div {width:640px; height:900px; padding-top:10px; position:relative;}
	#gallery #fullsize div img {clear:both; display:block; margin:0 auto; border:0;}
	#gallery #fullsize div h3 {padding:10px 0 0 0; margin:0; font-size:18px;}
	#gallery #fullsize div p {padding:5px 0; margin:0; font-size:12px; line-height:18px;}



</style>		


</head>
<body onload= "my_height()">

<#include "../../global/header.html">

<div id="main">
  <div id="left_menu">
  <ul class="rolinList" id="rolin">
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/intro!view.action">大连介绍</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/history!view.action">大连历史</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="#">城市地图</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2>景点、公园</h2>
    </div>
    <div class="content">
    	<div class="content_item"><a href="${base}/city/article.action?id=2">市内</a></div>
        <div class="content_item"><a href="${base}/city/article.action?id=8">旅顺</a></div>
        <div class="content_item"><a href="${base}/city/article.action?id=9">开发区、金石滩</a></div>
    </div>
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/food!view.action?type=food">大连美食</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><#--<a href="${base}/city/housing!view.action?type=housing">-->
    					<a href="${base}/city/hotel.action">大连酒店</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/shopping!view.action?type=shopping">大连购物</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/transportation!view.action?type=transportation">大连交通</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/therapy!view.action?type=therapy">大连治疗</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/festival!view.action?type=festival">大连节日</a></h2>
    </div>
    
  </li>
  <li>
  	<div class="menu_title">
    <h2><a href="${base}/city/exhibition!view.action?type=exhibition">展会信息</a></h2>
    </div>
  </li>
  <li>
  	<div class="menu_title">
    <h2>其他信息</h2>
    </div>
    <div class="content">
    	<div class="content_item"><a href="${base}/city/insurance!view.action">保险</a></div>
        <div class="content_item"><a href="${base}/city/law!view.action">法律常识</a></div>
        <div class="content_item"><a href="${base}/city/cellphone!view.action">手机信息</a></div>
        <div class="content_item"><a href="${base}/city/advice!view.action">实用建议</a></div>
    </div>
  </li>
</ul>
  </div>
  
  <div id="main_right">
  	<div class="right_title">
    	<h3>>>酒店信息</h3>
    </div>
    
   <div class="right_content">
   		<#if hotelSearchList?exists>
    	<div style="text-align:center;margin-top:25px;">
    	符合要求的酒店有：<br/>
    	<#list hotelSearchList as hotel>
    		<span><a href="hotelInfo.action?id=${hotel.ID}">${hotel.NAME}</a></span>
    		<#if hotel_index%5=0><br/></#if>
    	</#list>
    	</div>
    	<br/>
    	<#else>
      	<p class="content_p">
     		<div id="gallery">
	   			<div id="fullsize">
	   				酒店相册
					<#assign pIndex=picIndex/>
	   				<#list albumPicList as albumPic>
					<div id="#${albumPic.PICID}">
						<img src="${base}${albumPic.PICPATH}" alt="${albumPic.PICNAME}" width="600" height="450"/>
						<#if albumPic_index=0>
						<a class="next" href="#${pIndex[albumPic_index+1]}"><b>Next</b></a>
						<#elseif albumPic_index+1=albumPicList?size>
						<a class="previous" href="#${pIndex[albumPic_index-1]}"><b>Previous</b></a>
						<#else>
						<a class="previous" href="#${pIndex[albumPic_index-1]}"><b>Previous</b></a><a class="next" href="#${pIndex[albumPic_index+1]}"><b>Next</b></a>
						</#if>
						<h3>${albumPic.PICNAME}</h3>
					</div>
					</#list>
				</div>
			</div>
			<div style="text-align:center;">
			${hotelInfo.NAME}
			</div>
			<div style="text-align:center;margin-top:10px;">
			位置：<b>${hotelInfo.location}</b>&nbsp;&nbsp;星级：<b>${hotelInfo.level}</b>&nbsp;&nbsp;功能：<b>${hotelInfo.func}</b>
			</div>
			<div style="margin-top:15px;">
			${hotelInfo.CONTENT}
			</div>
			
			</p>
    	</#if>
    
 </div>	
</div>
<#include "../../global/footer.html">
</body>
</html>
