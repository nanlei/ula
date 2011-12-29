<@p.page>
	<@app.naviBar navi="友情链接,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的友情链接，您可以维护这些信息。">
	<@app.button id="goBackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
	<form name="linkForm" action="link!update.action?id=${link.ID}" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加连接</td>
			</tr>
			<tr>
				<td>名称<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="30" value="${link.TITLE}" emptyInfo="请输入链接名称">
				</td>
			</tr>
			<tr>
				<td>地址(http开头)<@p.mustMark /></td>
				<td><input type="text" name="url" size="40" maxLength="100" value="${link.URL}" emptyInfo="请输入链接地址"></td>
			</tr>
			<tr>
				<td>是否显示</td>
				<td><input type="radio" name="tag" value="1" <#if link.TAG=1>checked="checked"</#if>>是&nbsp;&nbsp;<input type="radio" name="tag" value="0" <#if link.TAG=0>checked="checked"</#if>>否</td>
			</tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</@p.page>