<@p.page>
	<@app.naviBar navi="关于大连,城市信息管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的关于大连的信息，您可以维护相关信息，如需添加或删除，请联系开发人员">
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="35%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="20%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>标题</td>
		<td>类型</td>
		<td>更新人</td>
		<td>更新时间</td>
		<td>操作</td>
	</tr>
	<#assign count=1 />
	<#list cityList as city>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${city.TITLE}</td>
		<td>
			<#switch city.TAG>
				<#case "intro">大连介绍<#break>
				<#case "history">大连历史<#break>
				<#case "insurance">保险<#break>
				<#case "commonlaw">法律常识<#break>
				<#case "cellphone">手机信息<#break>
				<#case "advice">实用建议<#break>
				<#case "map">城市地图<#break>
			</#switch>
		</td>
		<td>${city.USERNAME}</td>
		<td>${city.DATE?datetime}</td>
		<td><a href="city!preUpdate.action?id=${city.ID}">修改</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if cityList.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无大连信息</div>
</#if>
</@p.page>