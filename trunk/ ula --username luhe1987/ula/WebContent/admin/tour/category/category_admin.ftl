<@p.page>
	<@app.naviBar navi="行程管理,行程分类管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的行程分类，您可以维护相关信息，注意删除类别将删除该分类下的所有文章">
	<@app.button id="newCategoryButton" onclick="$('#newCategory').toggle();this.blur();return false;" text="添加行程分类"/>
	</@app.naviInfo>
<div id="newCategory" style="display:none">
	<form name="resourceForm" action="category!add.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加行程分类</td>
			</tr>
			<tr>
				<td>分类名称<@p.mustMark /></td>
				<td>
					<input type="text" name="name" size="40" maxLength="15" emptyInfo="请输入分类名称">
				</td>
			</tr>
			<tr>
				<td>对应休假类型</td>
				<td>
					<#list vacationTypeList as vacationType>
					<input type="checkbox" name="vacationType" value="${vacationType.ID}">${vacationType.NAME}
					<br/>
					</#list>
				</td>
			</tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="15%" align="center">
	<col width="35%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="25%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>行程类别名称</td>
		<td>更细时间</td>
		<td>更新人</td>
		<td>操作</td>
	</tr>
	<#assign count=1 />
	<#list categoryList as category>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${category.NAME}</td>
		<td>${category.UPDATETIME?datetime}</td>
		<td>${category.USERNAME}</td>
		<td><a href="category!preUpdate.action?id=${category.ID}">修改</a> | <a href="category!delete.action?id=${category.ID}" onclick="return confirm('该类别下的所有文章也将被删除，确定吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if categoryList.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无行程分类</div>
</#if>
</@p.page>