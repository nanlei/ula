<@p.page>
	<@app.naviBar navi="关于城市,景点，公园,修改文章" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以修改关于城市部分的文章">
	<a class="navlink" href="javascript:history.go(-1)">返回</a>
	</@app.naviInfo>
<script type="text/javascript">
function selectCoverLink(type){
	var targetURL="${base}/admin/city/selectCoverLink.action?articleType="+type;
	var parameters='width=800,height=600,location=no,menubar=no,titlebar=no,toolbar=no,status=no';
	window.open(targetURL,'',parameters);
}
</script>
<form name="articleForm" action="updateTour.action?articleId=${articleInfo.ID}" method="post" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="20%" align="center">
	<col width="30%" align="center">
	<col width="20%" align="center">
	<col width="30%" align="center">
	<tr class="title">
		<td colspan="4">修改文章</td>
	</tr>
	<tr>
		<td>选择类别</td>
		<td>
			<select name="articleType" emptyInfo="请选择文章类别">
				<option>-请选择-</option>
				<option value="dalian" <#if articleInfo.TYPE='dalian'>selected</#if>>大连</option>
				<option value="lvshun" <#if articleInfo.TYPE='lvshun'>selected</#if>>旅顺</option>
				<option value="devzone" <#if articleInfo.TYPE='devzone'>selected</#if>>开发区，金石滩</option>
			</select>
		</td>
		<td>标题</td><td><input type="text" name="title" emptyInfo="请填写文章标题" value="${articleInfo.TITLE}"></td>
	</tr>
	<tr>
		<td>封面图片</td>
		<td colspan="3">
			<input type="text" name="coverLink" emptyInfo="请先选择封面图片，然后填写图片的链接地址" title="图片的链接地址应该从/images开始" value="${articleInfo.COVERLINK}">&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="navlink" onclick="selectCoverLink('common')">选择普通上传的图片</a>&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="navlink" onclick="selectCoverLink('editor')">选择Editor上传的图片</a>
		</td>
	</tr>
	<tr>
		<td colspan="4"><textarea name="content" id="content">${articleInfo.CONTENT}</textarea><@p.ckeditor id="content"/></td>
	</tr>
	<tr>
		<td colspan="4"><input type="submit" class="btn" value="提交">&nbsp;&nbsp;<input type="reset" class="btn" value="重置"></td>
	</tr>
</table>
</form>
</@p.page>