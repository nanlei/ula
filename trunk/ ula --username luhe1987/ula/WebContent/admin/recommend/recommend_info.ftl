<@p.page>
	<@app.naviBar navi="推荐管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示推荐的详情信息，您可以维护这些信息。">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
var basePath='${base}';
function showCover(path){
	$('#picDialog').dialog({modal:true,position:"center",width:200,height:150,title:"查看封面图片"});
	$('#picDialog img').attr('src',basePath+path);
}
</script>
<div id="picDialog" style="display:none">
	<img src="" width="179" height="121" />
</div>
<form name="recommendForm" method="post" action="recommend!update.action?id=${recommend.ID}" enctype="multipart/form-data" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">推荐信息详情</td>
	</tr>
	<tr>
		<td>标题<@p.mustMark /></td>
		<td><input type="text" name="title" value="${recommend.TITLE}" size="40" maxLength="50" emptyInfo="请输入文章标题"></td>
	</tr>
	<tr>
		<td>当前封面图片</td>
		<td><#if recommend.COVER?has_content><a href="javascript:void(0)" onclick="showCover('${recommend.COVER}')">点击查看</a><#else>暂无图片</#if></td>
	</tr>
	<tr>
		<td>修改封面图片</td>
		<td><@app.file id="cover" name="cover" /></td>
	</tr>
	
	<tr>
		<td>链接(如果添加的是链接，我们会转向链接而不是显示文章)</td>
		<td><input type="text" name="link"  value="<#if recommend.LINK?exists>${recommend.LINK}</#if>"/>
	</tr>
	
	<tr>
		<td>显示状态<@p.mustMark /></td>
		<td><input type="radio" name="tag" value="1" <#if recommend.TAG=1>checked</#if>>显示&nbsp;&nbsp;<input type="radio" name="tag" value="0" <#if recommend.TAG=0>checked</#if>>不显示</td>
	</tr>
	<tr>
		<td>最后更新时间</td>
		<td>${recommend.UPDATETIME?datetime}</td>
	</tr>
	<tr>
		<td>更新者</td>
		<td>${recommend.USERNAME}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea  id="content" name="content">${recommend.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>