<@p.page>
	<@app.naviBar navi="关于大连,景点公园管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于大连中景点，公园部分文章，您可以修改这些信息。其它操作请联系开发人员">
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
	<#list tourList as tour>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${tour.TITLE}</td>
		<td>
			<#switch tour.TYPE>
				<#case "dalian">大连<#break>
				<#case "lvshun">旅顺<#break>
				<#case "devzone">开发区<#break>
			</#switch>
		</td>
		<td>${tour.USERNAME}</td>
		<td>${tour.ADDTIME?datetime}</td>
		<td><a href="tour!preUpdate.action?id=${tour.ID}">修改</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<#if count=1>
	<p align="center"><font color="red">尚未添加文章</font></p>
</#if>
</@p.page>