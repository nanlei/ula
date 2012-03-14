<#-- 页面统一基础模板 -->
<#macro page index=false>
<#assign locale=locale_session!'-'/>
<#if locale=='-'>
	<#assign locale=request.getLocale()!'-'/>
</#if>
<#if locale=='-'>
	<#assign locale='zh'/>
</#if>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title><@s.property value="%{getText('front.index.title')}"/></title>
	<link href="${base}/css/indexv2.css" rel="stylesheet" type="text/css" />
	<link href="${base}/css/jqueryui/start/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
	<script src="${base}/js/jquery-1.7.1.min.gzjs" type="text/javascript"></script>
	<script src="${base}/js/jquery-ui-1.8.16.custom.min.gzjs" type="text/javascript"></script>
	<script src="${base}/js/jqueryui/datepicker/lang/${locale}.js" type="text/javascript"></script>
	<script src="${base}/js/index_tab.js" type="text/javascript"></script>
	<script src="${base}/js/myScrollPic.js" type="text/javascript"></script>
	<script src="${base}/js/common.js" type="text/javascript"></script>
	<#if index>
	<script src="${base}/js/index.js" type="text/javascript"></script>
	</#if>
	<#if !index>
	<script src="${base}/js/page.js" type="text/javascript"></script>
	</#if>
</head>
<body>
<#nested>
<div id="back_top"><a href="#"><@s.property value="%{getText('front.top')}"/></a></div>
</body>
<script language="javascript" type="text/javascript">
	<!--//--><![CDATA[//><!--
	var scrollPic_02 = new ScrollPic();
	scrollPic_02.scrollContId   = "banner_ad"; //内容容器ID
	scrollPic_02.arrLeftId      = "LeftArr";//左箭头ID
	scrollPic_02.arrRightId     = "RightArr"; //右箭头ID
	
	scrollPic_02.frameWidth     = 764;//显示框宽度
	scrollPic_02.pageWidth      = 191; //翻页宽度

	scrollPic_02.speed          = 10; //移动速度(单位毫秒，越小越快)
	scrollPic_02.space          = 10; //每次移动像素(单位px，越大越快)
	scrollPic_02.autoPlay       = true; //自动播放
	scrollPic_02.autoPlayTime   = 3; //自动播放间隔时间(秒)

	scrollPic_02.initialize(); //初始化
							
	//--><!]]>
</script>
</html>
</#macro>

<#-- 页面宏定义引入 -->
<#include "macro/header.ftl">
<#include "macro/banner.ftl">
<#include "macro/navigation.ftl">
<#include "macro/search.ftl">
<#include "macro/main_left.ftl">
<#include "macro/main_middle.ftl">
<#include "macro/main_right.ftl">
<#include "macro/footer.ftl">