<@p.page>
<@app.naviBar navi="关于我们,团队介绍" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于团队介绍或人员介绍内容编辑，用户可以修改团队介绍或人员介绍内容">
	</@app.naviInfo>

<#if alertMessage?exists><p align="center">${alertMessage}</p></#if>
<form action="team!update.action" method="post">

<table>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" id="title" size = "100"
			value="${teamInfo.title}"></input></td>
	</tr>
	<tr>
		<td valign="baseline">内容</td>
		<td><textarea class="ckeditor" cols="80" id="content" name="content"
	rows="10">${teamInfo.content}</textarea></td>
	</tr>
	<tr>
	<td colspan="2"><div align="center"><input type="submit" value="发表" style="height: 25px; width: 100px"/></div></td>
	</tr>
</table>

</form>

</@p.page>