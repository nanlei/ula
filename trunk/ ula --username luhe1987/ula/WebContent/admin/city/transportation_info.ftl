<@p.page>
	<@app.naviBar navi="关于大连,大连交通,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改关于大连中大连交通部分的文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<form name="transportationForm" action="transportation!update.action?id=${transportation.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改大连交通文章</td>
	</tr>
	<tr>
		<td>标题</td><td><input type="text" name="title" emptyInfo="请填写文章标题" value="${transportation.TITLE}" size="80"></td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${transportation.USERNAME}</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${transportation.ADDTIME?datetime}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" id="content">${transportation.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>