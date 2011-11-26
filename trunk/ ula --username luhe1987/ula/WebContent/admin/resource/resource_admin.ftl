<@p.page>
	<@app.naviBar navi="订阅管理,订阅资源管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的订阅资源，它们会通过邮件自动发给订阅的用户，您可以维护这些资源">
	<@app.button id="newResourceButton" onclick="$('#newResource').toggle();this.blur();return false;" text="添加订阅资源"/>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<div id="newResource" style="display:none">
	<form name="resourceForm" action="resource!add.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加订阅资源</td>
			</tr>
			<tr>
				<td>资源标题<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="50" emptyInfo="请输入资源标题">
				</td>
			</tr>
			<tr>
				<td colspan="2"><textarea  id="content" name="content">请填写资源内容(这会发送邮件，请注意资源大小)<@p.mustMark /></textarea><@p.ckeditor id="content"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="30%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>标题</td>
		<td>更新时间</td>
		<td>自动处理完毕</td>
		<td>已发送邮件数</td>
		<td>更新者</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list resourceList.list as resource>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${resource.TITLE}</td>
		<td>${resource.UPDATETIME?datetime}</td>
		<td><#if resource.TAG=1>是<#else>否</#if></td>
		<td>${resource.COUNTER?number?int}</td>
		<td>${resource.USERNAME}</td>
		<td><a href="resource!preUpdate.action?id=${resource.ID}">更新</a> | <a href="resource!delete.action?id=${resource.ID}" onclick="return confirm('确定要删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if resourceList.list.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无订阅资源</div>
</#if>
<div align="right">
	<@p.paging resourceList />
</div>
</@p.page>