<@p.page>
	<@app.naviBar navi="订阅管理,订阅用户管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的订阅用户，它们会收到系统自动发出的邮件，您可以维护这些订阅用户">
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="25%" align="center">
	<col width="20%" align="center">
	<col width="20%" align="center">
	<col width="25%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>E-Mail</td>
		<td>注册时间</td>
		<td>注册IP</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list subscriberList.list as subscriber>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${subscriber.EMAIL}</td>
		<td>${subscriber.REGTIME?datetime}</td>
		<td>${subscriber.REGIP}</td>
		<td><a href="subscriber!delete.action?id=${subscriber.ID}" onclick="return confirm('确定要删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if subscriberList.list.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无订阅用户</div>
</#if>
<div align="right">
	<@p.paging subscriberList />
</div>
</@p.page>