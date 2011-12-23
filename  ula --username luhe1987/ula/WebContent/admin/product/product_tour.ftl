<@p.page>
	<@app.naviBar navi="产品管理,添加行程" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面为产品添加行程文章">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
function selectAllCheckBox(){
	var flag=$('#selector').val();
	if(flag=='true'){
		unSelectAll('productForm','tourIds'),
		$('#selector').attr('value','false');
		$('#tip').html('全选');
	}else{
		selectAll('productForm','tourIds'),
		$('#selector').attr('value','true');
		$('#tip').html('取消');
	}
}

function checkSelected(){
	var count=getSelectedNum('productForm','tourIds');
	if(count<=0){
		alert('请至少选择一个行程');
		return false;
	}else{
		return true;
	}
}
</script>
<form name="productForm" method="post" action="product!addTour.action?id=${product.ID}" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="60%" align="center">
	<col width="10%" align="center">
	<col width="20%" align="center">
	<tr class="title">
		<td colspan="4">现在向【${product.NAME}】中添加行程</td>
	</tr>
	<tr class="subtitle">
		<td colspan="4">注意：请勾选文章后在当前页提交操作，翻页后则自动取消勾选项</td>
	</tr>
	<tr class="strong">
		<td>选择</td>
		<td>文章名称</td>
		<td>行程分类</td>
		<td>更新时间</td>
	</tr>
	<#assign checker=-1>
	<#list tourList.list as tour>
	<tr <@p.trChangeColor />>
		<#list productTourList as pt>
			<#if pt.TOUR_ID=tour.ID>
				<#assign checker=tour.ID />
			</#if>
		</#list>
		<td><input type="checkbox" name="tourIds" value="${tour.ID}" <#if checker=tour.ID>checked</#if>></td>
		<td>${tour.TITLE}</td>
		<td>${tour.CATEGORY_NAME}</td>
		<td>${tour.UPDATETIME?datetime}</td>
	</tr>
	</#list>
	<tr>
		<td><input type="checkbox" name="selectAll" onclick="selectAllCheckBox()"><span id="selector" value="false"></span><span id="tip">全选</span></td>
		<td colspan="3" align="right"><@p.paging tourList/></td>
	</tr>
	<tr>
		<td colspan="4">
			<@app.submit id="submitButton" value="提交"  onclick="return checkSelected()"/>&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
</@p.page>