<@p.page>
	<@app.naviBar navi="行程管理,休假类型管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内用于行程搜索的请假类型，仅方便查看其对应的行程分类，如需修改，请联系开发人员">
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="20%" align="center">
	<col width="50%" align="center">
	<col width="30%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>休假类型名称</td>
		<td>操作</td>
	</tr>
	<#assign count=1 />
	<#list vacationTypeList as vacationType>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${vacationType.NAME}</td>
		<td><a href="vacationTypeInfo.action?id=${vacationType.ID}">查看对应行程分类</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if vacationTypeList.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无休假类别</div>
</#if>
</@p.page>