<form action="link!update.action" method="post">
 <input type="hidden" name="id" value="${linkMap.Id}">
<table>
	<tr>
		<td>网址名称</td>
		<td><input type="text" name="title" id="title" size = "30" value ="${linkMap.title}">
		</input>(一个链接的名称，可以自定义)</td>
	</tr>
	<tr>
		<td valign="baseline">网址链接</td>
		<td><input type="text" name="url" id="content" size = "30" value ="${linkMap.url}">(http://开头)</td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="保存修改" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>