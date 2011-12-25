<@p.page>
	<@app.naviBar navi="关于我们,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改关于我们的文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<form name="aboutForm" action="about!update.action?id=${about.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改【
			<#switch about.TYPE>
				<#case "company">公司介绍<#break>
				<#case "business">业务范围<#break>
				<#case "team">人员介绍<#break>
				<#case "memory">美好回忆<#break>
			</#switch>】文章</td>
	</tr>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" emptyInfo="请填写文章标题" value="${about.TITLE}" size="40"></td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${about.AUTHOR}</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${about.DATE?datetime}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" id="content">${about.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>