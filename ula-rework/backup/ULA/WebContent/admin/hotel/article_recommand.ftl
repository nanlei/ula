<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店管理,酒店推荐" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店推荐的信息，您可以维护这些信息。">
	<@app.button id="gobackButton" onclick="javascript:window.open('hotelarticle.action','MainFrame')" text="返回"/>
	</@app.naviInfo>
	<form name="hotelRecommandForm" action="hotelRecommandUpdate.action" method="post" onSubmit="return validateForm(this)">
	<table class="default" width="100%">
		<col width="40%" align="center">
		<col width="60%" align="center">
		<tr class="title">
			<td colspan="2">修改酒店推荐信息</td>
		</tr>
		<tr>
			<td>名称</td>
			<td><input type="text" name="title" value="${recommandInfo.TITLE}" emptyInfo="请输入标题"></td>
		</tr>
		<tr>
			<td>更新时间</td>
			<td>${recommandInfo.UPDATETIME?datetime}</td>
		</tr>
		<tr>
			<td>更新者</td>
			<td>${recommandInfo.UPDATEUSER}</td>
		</tr>
		<tr>
			<td colspan="2"><textarea name="content" id="content">${recommandInfo.CONTENT}</textarea><@p.ckeditor id="content"/></td>
		</tr>
		<tr>
			<td colspan="2"><@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/></td>
		</tr>
	</table>
	</form>
</@p.page>