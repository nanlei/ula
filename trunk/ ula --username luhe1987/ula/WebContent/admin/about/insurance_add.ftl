<@p.page>
<@app.naviBar navi="关于城市,其他信息,保险" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于其它信息（保险）内容编辑，用户可以修改其他消息（保险）的内容">
	</@app.naviInfo>

	
<form action="insurance!add.action" method="post">

<table class="default" width="100%">
	<tr>
		<td align="center">标题</td>
		<td><input type="text" name="title" id="title" size = "50"
		></input></td>
	</tr>
	<tr>
		<td colspan ="2"><textarea  id="content" name="content"
	rows="10"></textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="发表" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>

</@p.page>