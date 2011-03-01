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
		height:750px;
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
    <h2><a href="${base}/city/housing!view.action?type=housing">大连居住</a></h2>
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
    	<h3>>></h3>
    </div>
    
   <div class="right_content">
    
    
      <p class="content_p">
      
     <div id="gallery">
	   <div id="fullsize">
		<div id="pic1">
			<img src="../click/pic1.jpg" alt="Ballet dancer" />
			<a class="previous" href="#pic10"><b>Previous</b></a><a class="next" href="#pic2"><b>Next</b></a>
			<h3>Ballet dancer</h3>
			<p>Followed by some descriptive text and maybe a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic2">
			<img src="../click/pic2.jpg" alt="Beetle on a daisy" />
			<a class="previous" href="#pic1"><b>Previous</b></a><a class="next" href="#pic3"><b>Next</b></a>

			<p>Another piece of descriptive text and again a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic3">
			<img src="../click/pic3.jpg" alt="Misty landscape" />
			<a class="previous" href="#pic2"><b>Previous</b></a><a class="next" href="#pic4"><b>Next</b></a>
			
			<p>Yet more descriptive text and maybe a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic4">
			<img src="../click/pic4.jpg" alt="Bird of prey" />
			<a class="previous" href="#pic3"><b>Previous</b></a><a class="next" href="#pic5"><b>Next</b></a>
			
			<p>And another line of descriptive text and maybe a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic5">
			<img src="../click/pic5.jpg" alt="Bird on barbed wire" />
			<a class="previous" href="#pic4"><b>Previous</b></a><a class="next" href="#pic6"><b>Next</b></a>
			
			<p>With descriptive text and maybe a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic6">
			<img src="../click/pic6.jpg" alt="Isn't he cute" />
			<a class="previous" href="#pic5"><b>Previous</b></a><a class="next" href="#pic7"><b>Next</b></a>
			
			<p>A description of the picture can go here with a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		<div id="pic7">
			<img src="../click/pic7.jpg" alt="Ladybirds" />
			<a class="previous" href="#pic6"><b>Previous</b></a><a class="next" href="#pic8"><b>Next</b></a>
			
			<p>Descriptive text and maybe a <a href="http://www.sharejs.com/">link</a>.</p>
		</div>
		
	</div>
	
</div>
酒店具体介绍, 有图片</p>
 </div>	
</div>

<#include "../../global/footer.html">

</body>
</html>
