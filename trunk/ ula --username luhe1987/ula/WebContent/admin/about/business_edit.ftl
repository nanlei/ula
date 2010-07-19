<@p.page>
<@app.naviBar navi="关于我们,业务范围" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于操作业务范围编辑，用户可以修改业务范围内容">
	</@app.naviInfo>
	
<#if alertMessage?exists><p align="center">${alertMessage}</p></#if>
<form action="biz!update.action" method="post">

<table class="default" width="100%">
	<tr>
		<td align="center">标题</td>
		<td><input type="text" name="title" id="title"
			value="${bizInfo.title}" size ="50"</input></td>
	</tr>
	<tr>
		<td colspan ="2"><textarea id="content" name="content"
	rows="10">${bizInfo.content}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="发表" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>

</@p.page> 