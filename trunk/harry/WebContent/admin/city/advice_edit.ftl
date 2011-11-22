<@p.page>
<@app.naviBar navi="关于城市,其他信息,实用建议" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于其它信息（实用建议）内容编辑，用户可以修改其他消息（实用建议）的内容">
	</@app.naviInfo>

	
<form action="advice!update.action" method="post">

<table class="default" width="100%">
	<tr>
		<td align="center">标题</td>
		<td><input type="text" name="title" id="title" size = "50"
			value="${advice.title}"></input></td>
	</tr>
	<tr>
		
		<td colspan ="2"><textarea  id="content" name="content"
	rows="10">${advice.content}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="发表" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>

</@p.page>