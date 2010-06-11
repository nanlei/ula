<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理中心|美好回忆|修改</title>
<link href="<%=request.getContextPath()%>/css/admin.css"
	rel="stylesheet" type="text/css" media="all" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<link href="<%=request.getContextPath()%>/css/editor.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="container">
<jsp:include page="/global/header.html"></jsp:include>

 <div id="pagebody"><!--页面主体-->
    <div id="sidebar"><!--侧边栏-->
		<div id="sidemenu">
			<ul>
				<li><a href="company!admin.action">公司介绍</a></li>
			
				<li ><a href="memory!admin.action">团队介绍</a></li>
			
				<li ><a href="biz!admin.action">业务范围</a></li>
			
				<li class="current"><a href="memory!admin.action">美好回忆</a></li>
			</ul>
		</div>
	</div>
	<!--主体内容-->
	<div id="mainbody">
	<div id="alerts">
<noscript>
<p><strong>CKEditor requires JavaScript to run</strong>. In a
browser with no JavaScript support, like yours, you should still see the
contents (HTML data) and you should be able to edit it normally, without
a rich editor interface.</p>
</noscript>
</div>
<form action="memory!update.action" method="post">

<table>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" id="title" size = "100"
			value="${memoryInfo.title}"></input></td>
	</tr>
	<tr>
		<td valign="baseline">内容</td>
		<td><textarea class="ckeditor" cols="80" id="content" name="content"
	rows="10">${memoryInfo.content}</textarea></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="发表" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>
  </div> 
  
 </div>
</div>

</body>
</html>