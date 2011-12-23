<@p.page>
	<@app.naviBar navi="关于大连,城市信息管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的关于大连的信息，您可以维护相关信息，如需添加或删除，请联系开发人员">
	</@app.naviInfo>
<form name="cityForm" action="city!update.action?id=${city.ID}" method="post" onSubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">修改城市信息</td>
	</tr>
	<tr>
		<td>标题<@p.mustMark /></td>
		<td><input type="text" name="title" size="40" emptyInfo="请输入标题" value="${city.TITLE}"></td>
	</tr>
	<tr>
		<td>类型</td>
		<td>
			<#switch city.TAG>
				<#case "intro">大连介绍<#break>
				<#case "history">大连历史<#break>
				<#case "insurance">保险<#break>
				<#case "commonlaw">法律常识<#break>
				<#case "cellphone">手机信息<#break>
				<#case "advice">实用建议<#break>
				<#case "map">城市地图<#break>
			</#switch>
		</td>
	</tr>
	<tr>
		<td>更新时间</td>
		<td>${city.DATE?datetime}</td>
	</tr>
	</tr>
		<td colspan="2"><textarea  id="content" name="content">${city.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	</tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>