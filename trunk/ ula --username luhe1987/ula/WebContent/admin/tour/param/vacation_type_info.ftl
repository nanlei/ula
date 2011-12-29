<@p.page>
	<@app.naviBar navi="行程管理,休假类型管理,对应行程分类" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示休假类型对应的行程分类，如需修改，请在行程分类管理中进行">
	<@app.button id="goBackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="100%" align="center">
	<tr class="title">
		<td>对应的行程分类</td>
	</tr>
	<tr>
		<td>
			<br/>
			<#list tourCategoryList as tourCategory>
			${tourCategory.NAME}<br/><br/>
			</#list>
		</td>
	</tr>
</table>
</@p.page>