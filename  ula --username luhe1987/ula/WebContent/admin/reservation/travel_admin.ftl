<@p.page>
<@app.naviBar navi="旅游行程预订,管理页面" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于管理旅游行程预订。可以浏览、处理客户的旅游行程预订。">
	</@app.naviInfo>
	
	<#if alertMessage?exists><p align="center">${alertMessage}</p></#if>
	
	<table class="default" width="90%" align="center">
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="20%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
		<tr class="title">
		<td>客户</td>
		<td>路线/要求</td>
		<td>订单日期</td>
		<td colspan = "2">操作</a></td>
		<td>状态</td>
		
		<#list travelReservList.list as travelReserv>
		<tr>
		<td>${travelReserv.contactName}</td>
		<td>${travelReserv.requirement}</td>
		<td>${travelReserv.order_date}</td>
		<td><a href= "${base}/reservation/travelReserv!detail.action?id=${travelReserv.Id}">查看</a></td>
		<td><a href= "${base}/reservation/travelReserv!remove.action?id=${travelReserv.Id}">删除</a></td>
		<td>
		<#if !travelReserv.done?exists || travelReserv.done == "no">
		未处理
		<#else>
		已处理
		</#if>
		</td>
		</#list>
	</table>
	
	<p align ="center"><@p.paging travelReservList/></p>
</@p.page>