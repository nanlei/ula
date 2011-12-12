<@p.page>
	<@app.naviBar navi="行程管理,行程分类管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示行程分类的详情，您可以维护相关信息">
	<@app.button id="goBackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
	<form name="resourceForm" action="category!update.action?id=${category.ID}" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">行程分类修改</td>
			</tr>
			<tr>
				<td>分类名称<@p.mustMark /></td>
				<td>
					<input type="text" name="name" size="40" maxLength="15" value="${category.NAME}" emptyInfo="请输入分类名称">
				</td>
			</tr>
			<tr>
				<td>对应休假类型</td>
				<td>
					<#assign checker=-1 />
					<#list vacationTypeList as vacationType>
						<#list categoryVTList as categoryVT>
							<#if categoryVT.VACATION_TYPE_ID=vacationType.ID>
								<#assign checker=vacationType.ID />
							</#if>
						</#list>
						<input type="checkbox" name="vacationType" value="${vacationType.ID}" <#if checker=vacationType.ID>checked</#if>>${vacationType.NAME}
						<br/>
					</#list>
				</td>
			</tr>
			<tr>
				<td>更新时间</td>
				<td>${category.UPDATETIME?datetime}</td>
			</tr>
			<tr>
				<td>更新人</td>
				<td>${category.USERNAME}</td>
			</tr>
			<tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</@p.page>