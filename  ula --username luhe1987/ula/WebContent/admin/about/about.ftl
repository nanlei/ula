
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="${base}/css/about.css" rel="stylesheet" type="text/css" />
<link href="${base}/css/index.css" rel="stylesheet" type="text/css" />


</head>
<body>
<div id="header">
  <div id="header_left"> </div>
  <div id="header_right"> </div>
</div>
<div id="navi">
  <ul id="nav">
    <li class="select nav_li_first"><a href="${base}">首页</a></li>
    <li class="nav_li"><a href="${base}/about/company!view.action">关于我们</a></li>
    <li class="nav_li"><a href="">关于大连</a></li>
    <li class="nav_li"><a href="">旅游项目</a></li>
    <li class="nav_li"><a href="">特色服务</a></li>
    <li class="nav_li"><a href="">支付方式</a></li>
    <li class="nav_li_last"><a href="">联系我们</a></li>
  </ul>
</div>
<div id="other">
  <div id="weather"></div>
  <div id="recommended">
    <div id="recommended_left">
      <div id="project_month">本月推荐 Project Month</div>
    </div>
    <div id="recommendd_right">
      <ul id="recommends">
        <li class="recommend_li">5月9日 旅行社动态内容1，内容1详情介绍。</li>
      </ul>
    </div>
  </div>
  <div id="contact">
    <div id="tel">Tel:400-4000-400 Email:abcd@efg.com</div>
    <div id="now">Now!</div>
  </div>
</div>
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
     <p class="content_p"><#if view.content?exists>${view.content}</#if>${recommendation}</p>
	     
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
