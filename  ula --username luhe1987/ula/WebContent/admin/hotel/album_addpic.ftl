<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店相册管理,相册添加照片" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店相册的信息，您可以向相册中添加照片。">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
var basePath='${base}';
function showPic(id,picTitle){
	var picPath='#picPath'+id;
	var path=$(''+picPath).text();
	$('#picDialog img').attr('src',basePath+path);
	$('#picDialog').dialog({modal:true,position:"center",width:330,height:235,title:picTitle});
}
function selectAllCheckBox(){
	var flag=$('#selector').val();
	if(flag=='true'){
		unSelectAll('addPicToAlbumForm','picIds'),
		$('#selector').attr('value','false');
	}else{
		selectAll('addPicToAlbumForm','picIds'),
		$('#selector').attr('value','true');
	}
}
</script>
<div id="picDialog" style="display:none">
	<img src="" width="300" height="225" />
</div>
<form name="addPicToAlbumForm" action="hotelAlbumAddPic.action?id=${hotelAlbum.ID}" method="post">
<table class="default" width="100%">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="25%" align="center">
	<tr class="title">
		<td colspan="7">添加照片</td>
	</tr>
	<tr class="stronghl">
		<td colspan="7"><div style="text-align:center">现在向相册【${hotelAlbum.NAME}】中添加照片，点击名称可查看照片，提交时仅对当前页有效。</div></td>
	</tr>
	<tr class="subtitle">
		<td><input type="checkbox" name="selectAllTop" onClick="selectAllCheckBox()"><span id="selector" value="false"></span>选择</td>
		<td>序号</td>
		<td>名称</td>
		<td>上传时间</td>
		<td>上传者</td>
		<td>上传方式</td>
		<td>文件路径</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list picsNotInAlbum.list as pic>
	<tr>
		<td><input type="checkbox" name="picIds" value="${pic.PICID}"></td>
		<td>${count}</td>
		<td><a href="javascript:void(0)" onclick="showPic('${pic.PICID}','${pic.PICNAME}')">${pic.PICNAME}</a></td>
		<td>${pic.PICTIME?datetime}</td>
		<td>${pic.PICUSER}</td>
		<td><#if pic.PICTAG='common'>普通上传<#elseif pic.PICTAG='editor'>Editor上传</#if></td>
		<td><span id="picPath${pic.PICID}">${pic.PICPATH}</td>
	</tr>
	<#assign count=count+1/>
	</#list>
	<tr>
		<td colspan="7"><@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/></td>
	</tr>
</table>
</form>
<div align="right">
	<@p.paging picsNotInAlbum />
</div>
</@p.page>