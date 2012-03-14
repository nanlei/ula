<@p.page>
<@app.naviBar navi="酒店预订,管理页面" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于管理酒店预订。可以浏览、处理客户的酒店预订。">
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
		<td>预订酒店</td>
		<td>订单日期</td>
		<td colspan = "2">操作</a></td>
		<td>状态</td>
		
		<#list hotelReservList.list as hotelReserv>
		<tr>
		<td>${hotelReserv.CONTACT}</td>
		<td>${hotelReserv.HOTEL_NAME}</td>
		<td>${hotelReserv.POST_TIME}</td>
		<td><a href= "${base}/reservation/hotelReserv!detail.action?id=${hotelReserv.ID}">查看</a></td>
		<td><a href= "${base}/reservation/hotelReserv!remove.action?id=${hotelReserv.ID}">删除</a></td>
		<td>
		<#if !hotelReserv.RESOLVER?exists || hotelReserv.RESOLVER == "no">
		未处理
		<#else>
		已处理
		</#if>
		</td>
		</#list>
	</table>
	
	<p align ="center"><@p.paging hotelReservList/></p>
</@p.page>