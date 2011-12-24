<@p.page>
	<@app.naviBar navi="关于大连,景点公园管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改关于大连中景点公园部分的文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<form name="tourForm" action="tour!update.action?id=${tour.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改【
			<#switch tour.TYPE>
				<#case "dalian">大连<#break>
				<#case "lvshun">旅顺<#break>
				<#case "devzone">开发区<#break>
			</#switch>】文章</td>
	</tr>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" emptyInfo="请填写文章标题" value="${tour.TITLE}" size="40"></td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${tour.USERNAME}</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${tour.ADDTIME?datetime}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" id="content">${tour.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>