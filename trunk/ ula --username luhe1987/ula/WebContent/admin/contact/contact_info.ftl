<@p.page>
	<@app.naviBar navi="联系我们,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改联系我们部分的文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<form name="contactForm" action="contact!update.action?id=${contact.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改【
			<#switch contact.TAG>
				<#case "russia">俄罗斯客户<#break>
				<#case "china">中国客户<#break>
				<#case "guest">游客<#break>
			</#switch>】文章</td>
	</tr>
	<tr>
		<td>标题</td>
		<td><input type="text" name="title" emptyInfo="请填写文章标题" value="${contact.TITLE}" size="40"></td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${contact.USERNAME}</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${contact.DATE?datetime}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea name="content" id="content">${contact.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>