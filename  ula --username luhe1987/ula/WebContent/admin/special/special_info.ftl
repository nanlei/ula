<@p.page>
	<@app.naviBar navi="特色服务,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改特色服务文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<form name="specialForm" action="special!update.action?id=${special.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改【
			<#switch special.TAG>
				<#case "visa">签证<#break>
				<#case "ticket">代订车、船票<#break>
				<#case "carrental">租车服务<#break>
				<#case "translation">翻译服务<#break>
				<#case "souvenir">代邮寄纪念品<#break>
				<#case "student">俄罗斯留学生之家<#break>
			</#switch>】文章</td>
	</tr>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" emptyInfo="请填写文章标题" value="${special.TITLE}" size="40"></td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${special.USERNAME}</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${special.UPDATETIME?datetime}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" id="content">${special.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>