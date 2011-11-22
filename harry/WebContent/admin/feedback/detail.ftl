<@p.page>
<@app.naviBar navi="客户反馈,查看客户反馈" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于查看，回复客户反馈。">
	
	</@app.naviInfo>
	
	<table>
	<tr>
	<td>客户姓名</td>
	<td>${feedbackDetail.customer}</td>
	</tr>
	<tr>
	<td>客户来源地</td>
	<td>${feedbackDetail.fromwhere}</td>
	</tr>
	<tr>
	<td>客户邮件地址</td>
	<td>${feedbackDetail.email}</td>
	</tr>
	<tr>
	<td>客户反馈时间</td>
	<td>${feedbackDetail.feedbackdate}</td>
	</tr>
	<tr>
	<td  VALIGN="top">客户反馈</td>
	<td><textarea name="feedback" rows="20" cols="100"><#if feedbackDetail.feedback?exists>${feedbackDetail.feedback}</#if></textarea></td>
	</tr>
	
	  <form method=post action="${base}/feedback/feedback!reply.action">
	  <input type="hidden" name="id" value =${feedbackDetail.Id}>
	  <table>
	  <tr>
		<td  VALIGN="top">回复客户反馈</td>
		<td><textarea name="reply" rows="20" cols="100"><#if feedbackDetail.reply?exists>${feedbackDetail.reply}</#if></textarea></td>
	  </tr>
	  <tr>
	  <td align = "center" colspan ="2">
	  	  <input type="submit" value ="保存回复">
	  </td>
	  </tr>
	  </table>

	  </form>
	
	
	</table>
	
	
	</@p.page>