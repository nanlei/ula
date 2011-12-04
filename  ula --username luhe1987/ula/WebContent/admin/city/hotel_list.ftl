<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>乐游旅游</title>
<link href="${base}/css/about.css" rel="stylesheet" type="text/css" />
<link href="${base}/css/jqueryui/start/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/js/common.js"></script>
<script type="text/javascript" src="${base}/js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="${base}/js/jquery-ui-1.8.16.custom.min.js"></script>
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

	#hotel_category, #search_box {
		text-align:center;
	}
	
	#hotel_category span a {
		font-family: Arial, Verdana;
		font-size: 14px;
		color:#2C5463;
		margin: 5px;
		text-decoration: none;
	}
	
	#hotel_category a:visited{
	         color: #666666
	       }
	
	#search_box{
		margin-top: 20px;
	}
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
    		<h3>>>大连酒店</h3>
    	</div>
    	<div class="right_content">
    		<p class="content_p">
    		
    			<div id="hotel_category">
    				<#list hotelList as hotel>
    				<span><a href="hotelLevel.action?level=${hotel.NAME}">${hotel.VALUE}</a></span>
    				</#list>
			    </div>
			    
			    <div id="search_box">
			    	<form name="searchForm" action="hotelSearch.action" method="post" onSubmit="return validateForm(this)">
					    	
					    	酒店搜索&nbsp;>>&nbsp;
					    	位置：<select name="location">
									<option value="">--请选择--</option>
									<#list locationList as location>
									<option value="${location.NAME}">${location.VALUE}</option>
									</#list>
								 </select>
							&nbsp;&nbsp;
							星级：<select name="level">
									<option value="">--请选择--</option>
									<#list levelList as level>
									<option value="${level.NAME}">${level.VALUE}</option>
									</#list>
								 </select>
							&nbsp;&nbsp;
							功能：<select name="func">
									<option value="">--请选择--</option>
									<#list funcList as func>
									<option value="${func.NAME}">${func.VALUE}</option>
									</#list>
								 </select>
							&nbsp;&nbsp;
							
							<span style="padding:0px;font-size:77.5%">
							<input id="searchSubmit" type="submit" value="搜索">
							</span> 
					
					</form>
			    </div>
			    <div style="text-align:center;margin-top:30px;">推荐酒店：${recommandHotel.TITLE}</div>
			    <div style="margin-top:5px;">${recommandHotel.CONTENT}</div>
			 </p>
		</div>
   </div>
</div>
<script>
	$('#searchSubmit').button();
</script>
<#include "../../global/footer.html">
</body>
</html>
