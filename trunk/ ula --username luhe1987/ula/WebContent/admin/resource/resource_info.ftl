<@p.page>
	<@app.naviBar navi="订阅管理,订阅资源管理,资源详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示订阅资源的详情，您可以维护这些资源">
	</@app.naviInfo>
	<form name="resourceForm" action="resource!update.action?id=${resource.ID}" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">修改订阅资源</td>
			</tr>
			<tr>
				<td>资源标题<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="50" value="${resource.TITLE}" emptyInfo="请输入资源标题">
				</td>
			</tr>
			<tr>
				<td>更新时间</td>
				<td>${resource.UPDATETIME?datetime}</td>
			</tr>
			<tr>
				<td>更新者</td>
				<td>${resource.USERNAME}</td>
			</tr>
			<tr>
				<td>是否自动处理完毕</td>
				<td><#if resource.TAG=1>是<#else>否</#if></td>
			</tr>
			<tr>
				<td>已发送邮件数</td>
				<td>${resource.COUNTER}</td>
			</tr>
			<tr>
				<td colspan="2"><textarea  id="content" name="content">${resource.CONTENT}</textarea><@p.ckeditor id="content"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</@p.page>