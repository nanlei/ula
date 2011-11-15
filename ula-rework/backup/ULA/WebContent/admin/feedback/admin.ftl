<@p.page>
<@app.naviBar navi="客户反馈,管理页面" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于管理客户反馈。可以浏览、回复、删除客户反馈。">
	</@app.naviInfo>
	
	<table class="default" width="90%" align="center">
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
		<tr class="title">
		<td>客户</td>
		<td>来自</td>
		<td>日期</td>
		<td colspan = "2">操作</a></td>
		<td >状态</a></td>
		
		<#list feedbackList.list as feedback>
		<tr>
		<td>${feedback.customer}</td>
		<td>${feedback.fromwhere}</td>
		<td>${feedback.feedbackdate}</td>
		<td><a href= "${base}/feedback/feedback!detail.action?id=${feedback.Id}">查看</a></td>
		<td><a href= "${base}/feedback/feedback!remove.action?id=${feedback.Id}">删除</a></td>
		<td><#if feedback.reply?exists>已处理 <#else>未处理</#if></td>
		</#list>
		
		<@p.paging feedbackList />
</@p.page>