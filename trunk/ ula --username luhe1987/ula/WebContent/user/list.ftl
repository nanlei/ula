<@p.page>
	<@app.naviBar navi="用户管理,用户信息" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有用户信息，您可以维护这些信息。">
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<table class="default" width="100%">
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>用户名</td>
		<td>真实名</td>
		<td>用户身份</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list userList.list as user>
	<tr>
		<td>${count}</td>
		<td>${user.USERNAME?default("")}</td>
		<td>${user.REALNAME?default("")}</td>
		<td><#if user.USERROLE='admin'>超级管理员<#else>普通用户</#if></td>
		<td><a href="preUpdateUser.action?userId=${user.USERID}">修改</a> | <a href="deleteUser.action?userId=${user.USERID}" onclick="return confirm('确定删除么?')">删除</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<div align="right">
	<@p.paging userList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加用户</font></p>
</#if>
</@p.page>