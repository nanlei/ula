<@p.page>
	<@app.naviBar navi="行程管理,行程文章管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的行程文章，您可以维护相关信息">
	<@app.button id="goBackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
var basePath='${base}';
function showCover(path){
	$('#picDialog').dialog({modal:true,position:"center",width:221,height:151,title:"查看封面图片"});
	$('#picDialog img').attr('src',basePath+path);
}
</script>
<div id="picDialog" style="display:none">
	<img src="" width="191" height="131" />
</div>
	<form name="tourForm" action="tour!update.action?id=${tour.ID}" method="post" enctype="multipart/form-data" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">修改行程文章</td>
			</tr>
			<tr>
				<td>标题<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="100" maxLength="15" value="${tour.TITLE}" emptyInfo="请输入文章标题">
				</td>
			</tr>
			<tr>
				<td>行程分类<@p.mustMark /></td>
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
				<td>封面图片</td>
				<td><#if tour.COVERLINK?has_content><a href="javascript:void(0)" onclick="showCover('${tour.COVERLINK}')">点击查看</a><#else>暂无图片</#if></td>
			</tr>
			<tr>
				<td>修改封面图片</td>
				<td><@app.file id="coverlink" name="coverlink" /></td>
			</tr>
			<tr>
				<td>简短描述<@p.mustMark /></td>
				<td><textarea cols="80" rows="7" name="description">${tour.DESCRIPTION}</textarea></td>
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
				<td>是否作为此行程类别的首页</td>
				<td>
						<#if tour.ASCATEGORYINDEX?exists && tour.ASCATEGORYINDEX=='Y'>
						<input type="radio" name="as_index" value="Y" checked/> 是
						<input type="radio" name="as_index" value="N" /> 否
					<#else>	
						<input type="radio" name="as_index" value="Y" /> 是
						<input type="radio" name="as_index" value="N" checked/> 否
					</#if>  
				</td>
			</tr>
			<tr>
				<td>是否出现来表格里</td>
				<td>
				    <#if tour.SHOWINTABLE?exists && tour.SHOWINTABLE=='Y'>
						<input type="radio" name="show_in_table" value="Y" checked/> 是
						<input type="radio" name="show_in_table" value="N" /> 否
					<#else>	
						<input type="radio" name="show_in_table" value="Y" /> 是
						<input type="radio" name="show_in_table" value="N" checked/> 否
					</#if>  
				</td>
			</tr>
			
			<tr>
				<td colspan="2">文章内容是  #NO#的时候，文章部分会隐藏起来</td>
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