<@p.page>
	<@app.naviBar navi="关于城市,大连节日" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以添加大连节日部分的文章">
	<a class="navlink" href="javascript:history.go(-1)">返回</a>
	</@app.naviInfo>
<script type="text/javascript">
function selectCoverLink(type){
	var targetURL="${base}/admin/city/selectCoverLink.action?articleType="+type;
	var parameters='width=800,height=600,location=no,menubar=no,titlebar=no,toolbar=no,status=no';
	window.open(targetURL,'',parameters);
}
</script>
<form name="articleForm" action="addFestival.action" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="15%" align="center">
	<col width="35%" align="center">
	<col width="15%" align="center">
	<col width="35%" align="center">
	<tr class="title">
		<td colspan="4">添加文章</td>
	</tr>
	<tr>
		<td>标题</td><td><input type="text" name="title" emptyInfo="请填写文章标题"></td>
		<td>封面图片</td>
		<td>
			<input type="text" name="coverLink" emptyInfo="请先选择封面图片，然后填写图片的链接地址" title="图片的链接地址应该从/images开始">&nbsp;
			<a href="javascript:void(0)" class="navlink" onclick="selectCoverLink('common')">普通上传</a>&nbsp;
			<a href="javascript:void(0)" class="navlink" onclick="selectCoverLink('editor')">Editor上传</a>
		</td>
	</tr>
	<tr>
		<td>参考价格</td><td><input type="text" name="price" numberInfo="请填写价格，并且是数字格式"></td>
		<td></td><td></td>
	</tr>
	<tr>
		<td colspan="4"><textarea name="content" id="content"></textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="4"><input type="submit" class="btn" value="提交">&nbsp;&nbsp;<input type="reset" class="btn" value="重置"></td>
	</tr>
</table>
</form>
</@p.page>