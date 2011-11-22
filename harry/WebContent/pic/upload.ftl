<@p.page>
	<@app.naviBar navi="图片管理,普通上传,上传图片" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="您可以在这里上传图片。图片格式限制为jpg，jpeg，gif，png和bmp">
	</@app.naviInfo>
<form name="picForm" action="upload.action" method="post" enctype="multipart/form-data">
<table class="default" width="100%">
	<col width="40%" align="right"/>
	<col width="60%" align="left"/>
	<tr class="title">
		<td colspan="2">上传图片</td>
	</tr>
	<tr>
		<td>选择文件</td><td><input type="file" class="fbtn" name="picture"></td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="提交" class="btn">&nbsp;&nbsp;<input type="reset" value="重置" class="btn"></td>
	</tr>
</table>
</@p.page>