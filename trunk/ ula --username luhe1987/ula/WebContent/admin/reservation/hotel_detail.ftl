<@p.page>
<@app.naviBar navi="客户反馈,查看客户反馈" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于查看，回复客户反馈。">
	
	</@app.naviInfo>
	
	<table>
	<tr>
	<td>客户姓名：</td>
	<td>${reservation.name}</td>
	</tr>
	<tr>
	<td>电话：</td>
	<td>${reservation.phoneNumber}</td>
	</tr>
	<tr>
	<td>其他联系方式：</td>
	<td>${reservation.contact}</td>
	</tr>
	<tr>
	<td>酒店名称：</td>
	<td>${reservation.hotelName}</td>
	</tr>
	<tr>
	<td>房间数量：</td>
	<td>${reservation.roomTotal}</td>
	</tr>
	<tr>
	<td>入住日期：</td>
	<td>${reservation.checkinDate}</td>
	</tr>
	<tr>
	<td>离开日期：</td>
	<td>${reservation.checkoutDate}</td>
	</tr>
	<tr>
	<td>入住人数：</td>
	<td>${reservation.guestTotal}</td>
	</tr>
	
	<tr>
	<td>备注说明：</td>
	<td><textarea rows="10" cols="25">${reservation.remarks}</textarea></td>
	</tr>
</table>

<#if !reservation.done?exists || reservation.done == "no">
<form method=post action="${base}/reservation/hotelReserv!done.action?id=${reservation.Id}">
	  	  <input type="submit" value ='标记为 已处理'>
	  	  
	  </form>
<#else>
<form method=post action="${base}/reservation/hotelReserv!undone.action?id=${reservation.Id}">
	  	  <input type="submit" value ='标记为 未处理'>
	  </form>
</#if>


 

	
	
	
	
	</@p.page>