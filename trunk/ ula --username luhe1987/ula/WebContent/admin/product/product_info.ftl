<@p.page>
	<@app.naviBar navi="产品管理,详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示产品的详情信息，您可以维护这些信息。">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
var basePath='${base}';
function showCover(path){
	$('#picDialog').dialog({modal:true,position:"center",width:210,height:160,title:"查看封面图片"});
	$('#picDialog img').attr('src',basePath+path);
}
</script>
<div id="picDialog" style="display:none">
	<img src="" width="179" height="121" />
</div>
<form name="productForm" method="post" action="product!update.action?id=${product.ID}" enctype="multipart/form-data" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">产品信息</td>
	</tr>
	<tr class="subtitle">
		<td colspan="2">仅修改产品信息，修改行程文章请返回重新选择</td>
	</tr>
	<tr>
		<td>产品名称<@p.mustMark /></td>
		<td><input type="text" name="name" value="${product.NAME}" size="40" maxLength="50" emptyInfo="请输入产品名称"></td>
	</tr>
	<tr>
		<td>产品价格<@p.mustMark /></td>
		<td><input type="text" name="price" value="${product.PRICE}" size="40" maxLength="50" emptyInfo="请输入产品价格" numberInfo="价格仅能是数字"></td>
	</tr>
	<tr>
		<td>首页显示(最多设置12个)<@p.mustMark /></td>
		<td><input type="radio" name="tag" value="1" <#if product.TAG=1>checked<#elseif (displayNum>=12)>disabled="disabled"<#else></#if>>是&nbsp;&nbsp;
			<input type="radio" name="tag" value="0" <#if product.TAG=0>checked<#else></#if>>否</td>
	</tr>
	<tr>
		<td>当前封面图片</td>
		<td><#if product.COVER?has_content><a href="javascript:void(0)" onclick="showCover('${product.COVER}')">点击查看</a><#else>暂无图片</#if></td>
	</tr>
	<tr>
		<td>修改封面图片</td>
		<td><@app.file id="cover" name="cover" /></td>
	</tr>
	
	<tr>
		<td>链接(如果添加的是链接，我们会转向链接而不是显示文章)</td>
		<td><input type="text" name="link"  value="<#if product.LINK?exists>${product.LINK}</#if>"/>
	</tr>
	
	<tr>
		<td>最后更新时间</td>
		<td>${product.UPDATETIME?datetime}</td>
	</tr>
	<tr>
		<td>更新人</td>
		<td>${product.USERNAME}</td>
	</tr>
	<tr>
		<td colspan="2"><textarea  id="description" name="description">${product.DESCRIPTION}</textarea><@p.ckeditor id="description"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>