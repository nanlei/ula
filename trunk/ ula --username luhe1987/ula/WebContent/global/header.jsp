<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<link href="<%=request.getContextPath()%>/css/index.css" rel="stylesheet" type="text/css" />

<div id="header">
<div id="header_left"></div>
<div id="header_right"></div>
</div>

<div id="navi">
<ul id="nav">
	<li class="select nav_li_first"><a href="<%=request.getContextPath()%>/">首页</a></li>
	<li class="nav_li"><a href="<%=request.getContextPath()%>/about/company!view.action">关于我们</a></li>
	<li class="nav_li"><a href="">关于大连</a></li>
	<li class="nav_li"><a href="">旅游项目</a></li>
	<li class="nav_li"><a href="">特色服务</a></li>
	<li class="nav_li"><a href="">支付方式</a></li>
	<li class="nav_li_last"><a href="">联系我们</a></li>
</ul>
</div>

<div id="other">
<div id="weather" align="center">Weather In Dalian</div>
<div id="recommended">
<div id="recommended_left">
<div id="project_month"> Recommendation Monthly</div>
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