<@p.page>
	<@app.naviBar navi="特色服务" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的特色服务文章，您可以修改这些信息。其它操作请联系开发人员">
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="35%" align="center"/>
	<col width="15%" align="center"/>
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
	<#list specialList as special>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${special.TITLE}</td>
		<td>
			<#switch special.TAG>
				<#case "visa">签证<#break>
				<#case "ticket">代订车、船票<#break>
				<#case "carrental">租车服务<#break>
				<#case "translation">翻译服务<#break>
				<#case "souvenir">代邮寄纪念品<#break>
				<#case "student">俄罗斯留学生之家<#break>
				<#case "payment">支付方式<#break>
			</#switch>
		</td>
		<td>${special.USERNAME}</td>
		<td>${special.UPDATETIME?datetime}</td>
		<td><a href="special!preUpdate.action?id=${special.ID}">修改</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<#if count=1>
	<p align="center"><font color="red">尚未添加文章</font></p>
</#if>
</@p.page>