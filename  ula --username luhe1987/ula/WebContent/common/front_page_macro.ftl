<#-- 页面统一基础模板 -->
<#macro page>
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
	<link href="css/indexv2.css" rel="stylesheet" type="text/css" />
	<link href="css/jqueryui/start/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
	<script src="js/jquery-1.7.1.min.js" type="text/javascript"></script>
	<script src="js/jquery-ui-1.8.16.custom.min.js" type="text/javascript"></script>
	<script src="js/jqueryui/datepicker/lang/${locale}.js" type="text/javascript"></script>
	<script src="js/index_tab.js" type="text/javascript"></script>
	<script src="js/ScrollPic.js" type="text/javascript"></script>
	<script src="js/index.js" type="text/javascript"></script>
</head>
<#nested>
</#macro>

<#-- 页面宏定义引入 -->
<#include "macro/header.ftl">
<#include "macro/banner.ftl">
<#include "macro/navigation.ftl">
<#include "macro/search.ftl">