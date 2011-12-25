<@p.page>
	<@app.naviBar navi="关于我们" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于我们文章，您可以修改这些信息。其它操作请联系开发人员">
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="40%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="15%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>标题</td>
		<td>类型</td>
		<td>更新人</td>
		<td>更新时间</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list aboutList as about>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${about.TITLE}</td>
		<td>
			<#switch about.TYPE>
				<#case "company">公司介绍<#break>
				<#case "business">业务范围<#break>
				<#case "team">人员介绍<#break>
				<#case "memory">美好回忆<#break>
			</#switch>
		</td>
		<td>${about.AUTHOR}</td>
		<td>${about.DATE?datetime}</td>
		<td><a href="about!preUpdate.action?id=${about.ID}">修改</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<#if count=1>
	<p align="center"><font color="red">尚未添加文章</font></p>
</#if>
</@p.page>