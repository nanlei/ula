<@p.page>
	<@app.naviBar navi="汇率管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示汇率信息，系统每30分钟自动更新一次，首页最多显示8个。">
	</@app.naviInfo>
 <table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="25%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="25%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>名称</td>
		<td>汇率(单位:1卢布兑换值)</td>
		<td>是否显示</td>
		<td>发布时间</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list exchangeList as exchange>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${exchange.TITLE}</td>
		<td>${exchange.VALUE}</td>
		<td><#if exchange.TAG=1>是<#else>否</#if></td>
		<td>${exchange.PUB_DATE?datetime}</td>
		<td><#if exchange.TAG=0><#if (displayCount>=8)><a disabled="disabled">显示</a><#else><a href="exchange!display.action?id=${exchange.ID}">显示</a></#if>
			<#else><a href="exchange!cancelDisplay.action?id=${exchange.ID}">取消显示</a></#if></td>
	</tr>
	<#assign count=count+1>
	</#list>	
</table>
<#if count=1>
	<p align="center"><font color="red">没有汇率信息</font></p>
</#if>
</@p.page>