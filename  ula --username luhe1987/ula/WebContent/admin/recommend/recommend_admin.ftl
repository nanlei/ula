<@p.page>
	<@app.naviBar navi="推荐管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的推荐文章，您可以进行管理。">
	<@app.button id="newRecommendButton" onclick="$('#newRecommend').toggle();this.blur();return false;" text="添加文章"/>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<div id="newRecommend" style="display:none">
	<form name="recommendForm" action="recommend!add.action" method="post" enctype="multipart/form-data" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加推荐文章</td>
			</tr>
			<tr>
				<td>文章标题<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="50" emptyInfo="请输入文章标题">
				</td>
			</tr>
			<tr>
				<td>封面图片<@p.mustMark /></td>
				<td><@app.file id="cover" name="cover" emptyInfo="请选择封面图片"/></td>
			</tr>
			<tr>
				<td>是否显示<@p.mustMark /></td>
				<td><input type="radio" name="tag" value="1" checked>显示&nbsp;&nbsp;<input type="radio" name="tag" value="0">不显示</td>
			</tr>
			<tr>
				<td colspan="2"><textarea  id="content" name="content">请填写文章内容<@p.mustMark /></textarea><@p.ckeditor id="content"/></td>
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
	<col width="35%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="20%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>标题</td>
		<td>更新时间</td>
		<td>更新者</td>
		<td>显示状态</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list recommendList.list as recommend>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${recommend.TITLE}</td>
		<td>${recommend.UPDATETIME?datetime}</td>
		<td>${recommend.USERNAME}</td>
		<td><#if recommend.TAG=1>显示中<#else>不显示</#if></td>
		<td><a href="recommend!preUpdate.action?id=${recommend.ID}">修改</a> | <a href="recommend!delete.action?id=${recommend.ID}" onclick="return confirm('确定删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if recommendList.list.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无推荐文章</div>
</#if>
<div align="right">
	<@p.paging recommendList />
</div>
</@p.page>