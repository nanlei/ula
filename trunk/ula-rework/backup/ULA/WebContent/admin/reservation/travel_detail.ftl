<@p.page>
<@app.naviBar navi="客户反馈,查看客户反馈" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于查看，回复客户反馈。">
	
	</@app.naviInfo>
	
	<table>
	  <tr>
	<td>旅游人数：</td>
	<td>${travelReserv.touristNum}</td>
  </tr>
  <tr>
	<td>出游日期</td>
	<td>${travelReserv.startDate}</td>
  </tr>
  <tr>
	<td>返程日期</td>
	<td>${travelReserv.returnDate}</td>
  </tr>
    <tr>
	<td>最晚答复日期</td>
	<td>${travelReserv.replyDeadline}</td>
  </tr>
  <tr>
	<td>旅游路线/要求</td>
	<td><textarea rows="10" cols="20">${travelReserv.requirement}</textarea></td>
  </tr>

  </table>
  
  

  <table>
  <tr>
	<td>联系人信息</td>
	<td></td>
  </tr>
  
  <tr>
	<td>姓名</td>
	<td>${travelReserv.contactName}</td>
  </tr>
    <tr>
	<td>性别</td>
	<td><#if travelReserv.contactGender?exists && travelReserv.contactGender=="male">男<#else>女</#if></td>
  </tr>
  <tr>
	<td>手机|电话</td>
	<td>${travelReserv.contactPhone}</td>
  </tr>
  <tr>
	<td>Email</td>
	<td>${travelReserv.contactEmail}</td>
  </tr>
</table>

<#if !travelReserv.done?exists || travelReserv.done == "no">
<form method=post action="${base}/reservation/travelReserv!done.action?id=${travelReserv.Id}">
	  	  <input type="submit" value ='标记为 已处理'> 	  
	  </form>
<#else>
 <form method=post action="${base}/reservation/travelReserv!undone.action?id=${travelReserv.Id}">
	  	  <input type="submit" value ='标记为 未处理'>
	  </form>
</#if>
	</@p.page>