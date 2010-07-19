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
	<td>${reservation.tel}</td>
	</tr>
	<tr>
	<td>Email：</td>
	<td>${reservation.email}</td>
	</tr>
	<tr>
	<td>酒店名称：</td>
	<td>${reservation.hotelName}</td>
	</tr>
	<tr>
	<td>客房类型：</td>
	<td>${reservation.roomCategory}</td>
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
	<td>男性人数：</td>
	<td>${reservation.men}</td>
	</tr>
	<tr>
	<td>女性人数：</td>
	<td>${reservation.women}</td>
	</tr>
	<tr>
	<td>儿童人数：</td>
	<td>${reservation.kids}</td>
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