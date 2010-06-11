<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理中心|美好回忆</title>
<link href="<%=request.getContextPath()%>/css/admin.css"
	rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<div id="container">
<jsp:include page="/global/header.html"></jsp:include>

 <div id="pagebody"><!--页面主体-->
    <div id="sidebar"><!--侧边栏-->
		<div id="sidemenu">
			<ul>
			
				<li ><a href="company!admin.action">公司介绍</a></li>
			
				<li ><a href="team!admin.action">团队介绍</a></li>
			
				<li><a href="biz!admin.action">业务范围</a></li>
			
				<li class="current"><a href="memory!admin.action">美好回忆</a></li>
			</ul>
		</div>
	</div>
	<!--主体内容-->
	<div id="mainbody">
	<!--如果没有添加公司信息，则允许添加--> 
	<c:if test="${memoryInfo==null}">
		<div class="add"><a href="memory!preAdd.action"><img
			src="<%=request.getContextPath()%>/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
		</div>
	</c:if> 
	
	<c:if test="${alertMessage!=null}">
		<table class="infobox" width="30px">
			<tr>
				<td class="tablecc">${alertMessage}</td>
			</tr>
		</table>
   </c:if>

	<c:if test="${memoryInfo!=null}">
		<table id="customers">
			<tr>
				<td>标题</td>
				<td>发布时间</td>
				<td colspan="3" align="center">操作</td>
			</tr>
			<tr class="alt">
				<td>${memoryInfo.title}</td>
				<td>${memoryInfo.date}</td>
	
				<td class="operation"><a href="memory!edit.action"><img
					src="<%=request.getContextPath()%>/icon/edit.png" border="0"
					height="15px" width="15px" />修改</a></td>
				<td class="operation">删除</td>
			</tr>
		</table>
	</c:if>
	
  </div> 
  
 </div>
</div>

</body>
</html>