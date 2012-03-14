<@p.page>
<@app.naviBar navi="客户反馈,查看客户反馈" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于查看，回复客户反馈。">
	
	</@app.naviInfo>
	
	<table>
	<tr>
	<td>客户姓名：</td>
	<td>${reservation.CONTACT}</td>
	</tr>
	<tr>
	<td>电话：</td>
	<td>${reservation.PHONE_NUMBER}</td>
	</tr>
	<tr>
	<td>其他联系方式：</td>
	<td>${reservation.CONTACT_VALUE}</td>
	</tr>
	<tr>
	<td>酒店名称：</td>
	<td>${reservation.HOTEL_NAME}</td>
	</tr>
	<tr>
	<td>房间数量：</td>
	<td>${reservation.ROOM_TOTAL}</td>
	</tr>
	<tr>
	<td>入住日期：</td>
	<td>${reservation.CHECK_IN_DATE}</td>
	</tr>
	<tr>
	<td>离开日期：</td>
	<td>${reservation.CHECK_IN_DATE}</td>
	</tr>
	<tr>
	<td>入住人数：</td>
	<td>${reservation.GUEST_TOTAL}</td>
	</tr>
	
	<tr>
	<td>备注说明：</td>
	<td><textarea rows="10" cols="25">${reservation.REMARKS}</textarea></td>
	</tr>
</table>

<#if !reservation.RESOLVER?exists || reservation.RESOLVER == "no">
<form method=post action="${base}/reservation/hotelReserv!done.action?id=${reservation.ID}">
	  	  <input type="submit" value ='标记为 已处理'>
	  	  
	  </form>
<#else>
<form method=post action="${base}/reservation/hotelReserv!undone.action?id=${reservation.ID}">
	  	  <input type="submit" value ='标记为 未处理'>
	  </form>
</#if>


 

	
	
	
	
	</@p.page>