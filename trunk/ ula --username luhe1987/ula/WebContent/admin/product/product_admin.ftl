<@p.page>
	<@app.naviBar navi="产品管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内所有的产品信息，您可以维护相关信息">
	<@app.button id="newProductButton" onclick="$('#newProduct').toggle();this.blur();return false;" text="添加产品"/>
	</@app.naviInfo>
<div id="newProduct" style="display:none">
	<form name="productForm" action="product!add.action" method="post" enctype="multipart/form-data" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加产品</td>
			</tr>
			<tr class="subtitle">
				<td colspan="2">先填写下列产品信息，创建成功后再添加行程文章</td>
			</tr>
			<tr>
				<td>名称<@p.mustMark /></td>
				<td>
					<input type="text" name="name" size="40" maxLength="15" emptyInfo="请输入产品名称">
				</td>
			</tr>
			<tr>
				<td>价格<@p.mustMark /></td>
				<td><input type="text" name="price" size="40" maxLength="15" emptyInfo="请输入产品价格" numberInfo="产品价格为纯数字"></td>
			</tr>
			<tr>
				<td>首页显示(最多设置12个)<@p.mustMark /></td>
				<td><input type="radio" name="tag" value="1" <#if (displayNum<12)>checked<#else>disabled="disabled"</#if>>是&nbsp;&nbsp;<input type="radio" name="tag" value="0" <#if (displayNum>=12)>checked</#if>>否</td>
			</tr>
			<tr>
				<td>封面图片<@p.mustMark /></td>
				<td><@app.file id="cover" name="cover" emptyInfo="请选择封面图片"/></td>
			</tr>
			
			<tr>
				<td>链接(如果添加的是链接，我们会转向链接而不是显示产品列表)</td>
				<td><input type="text" name="link"/>
			</tr>
			
			<tr>
				<td colspan="2"><textarea  id="description" name="description">请输入简短描述内容<@p.mustMark /></textarea><@p.ckeditor id="description"/></td>
			</tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="25%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="20%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>产品名称</td>
		<td>产品价格</td>
		<td>更新时间</td>
		<td>首页显示</td>
		<td>更新人</td>
		<td>操作</td>
	</tr>
	<#assign count=1 />
	<#list productList.list as product>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${product.NAME}</td>
		<td>${product.PRICE}</td>
		<td>${product.UPDATETIME?datetime}</td>
		<td><#if product.TAG=1>是<#else>否</#if></td>
		<td>${product.USERNAME}</td>
		<td><a href="product!preUpdate.action?id=${product.ID}">修改</a> | <a href="product!preAddTour.action?id=${product.ID}">行程文章</a> | <a href="product!delete.action?id=${product.ID}" onclick="return confirm('确定删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if productList.list.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无产品</div>
</#if>
<div align="right">
	<@p.paging productList />
</div>
</@p.page>