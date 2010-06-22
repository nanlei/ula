
<form action="interface!update.action?id=${lanMap.Id}" method="post">
<table>
	<tr>
		<td>中文原文</td>
		<td><input type="text" name="lang_CN" id="lang_CN" size = "30"
		value="${lanMap.CN}"></input></td>
	</tr>
		<tr>
		<td>页面引用值</td>
		<td><input type="text" name="lang_TAG" id="lang_TAG" size = "30" value="${lanMap.TAG}"></input></td>
	</tr>
	<tr>
		<td valign="baseline">俄文译文</td>
		<td><input type="text" name="lang_RU" id="lang_RU" size = "30" value ="${lanMap.RU}"></input></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="保存修改" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>
</form>