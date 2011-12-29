<@p.page>
	<@app.naviBar navi="行程管理,行程文章管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的行程文章，您可以维护相关信息">
	<@app.button id="goBackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
	<form name="resourceForm" action="tour!update.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">修改行程文章</td>
			</tr>
			<tr>
				<td>标题<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="15" value="${tour.TITLE}" emptyInfo="请输入文章标题">
				</td>
			</tr>
			<tr>
				<td>行程分类</td>
				<td>
					<select name="cid" emptyInfo="请选择行程分类">
						<option>--请选择--</option>
						<#list categoryList as category>
						<option value="${category.ID}" <#if category.ID=tour.CATEGORY_ID>selected="selected"</#if>>${category.NAME}</option>
						</#list>
					</select>
				</td>
			</tr>
			<tr>
				<td>更新时间</td>
				<td>${tour.UPDATETIME?datetime}</td>
			</tr>
			<tr>
				<td>更新人</td>
				<td>${tour.USERNAME}</td>
			</tr>
			<tr>
				<td colspan="2"><textarea  id="content" name="content">${tour.CONTENT}</textarea><@p.ckeditor id="content"/></td>
			</tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</@p.page>