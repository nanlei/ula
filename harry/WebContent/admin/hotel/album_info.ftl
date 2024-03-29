<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店相册管理,相册详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店相册的详情信息，您可以维护这些信息。">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
<script type="text/javascript">
var basePath='${base}';
function showPic(id,picTitle){
	var picPath='#picPath'+id;
	var path=$(''+picPath).text();
	$('#picDialog').dialog({modal:true,position:"center",width:330,height:235,title:picTitle});
	$('#picDialog img').attr('src',basePath+path);
}
function selectAllCheckBox(){
	var flag=$('#selector').val();
	if(flag=='true'){
		unSelectAll('picInAlbumForm','picIds'),
		$('#selector').attr('value','false');
	}else{
		selectAll('picInAlbumForm','picIds'),
		$('#selector').attr('value','true');
	}
}

function checkSelected(){
	var count=getSelectedNum('picInAlbumForm','picIds');
	if(count<=0){
		alert('请至少选择一张照片');
		return false;
	}else{
		return true;
	}
}
</script>
<div id="picDialog" style="display:none">
	<img src="" width="300" height="225" />
</div>
<form name="albumInfoForm" method="post" action="updateAlbum.action?id=${hotelAlbum.ID}" onsubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="40%" align="center">
	<col width="60%" align="center">
	<tr class="title">
		<td colspan="2">相册基本信息</td>
	</tr>
	<tr>
		<td>相册名称</td>
		<td><input type="text" name="name" value="${hotelAlbum.NAME}" size="40" maxLength="50" emptyInfo="请输入相册名称"></td>
	</tr>
	<tr>
		<td>相册内容</td>
		<td><textarea name="content" cols="80" rows="8" emptyInfo="请输入相册内容">${hotelAlbum.CONTENT}</textarea></td>
	</tr>
	<tr>
		<td>发布时间</td>
		<td>${hotelAlbum.POSTTIME?datetime}</td>
	</tr>
	<tr>
		<td>发布者</td>
		<td>${hotelAlbum.USERNAME}</td>
	</tr>
	<tr>
		<td colspan="2">
			<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
		</td>
	</tr>
</table>
</form>
<div style="margin-top:10px;"/>
<#if picsInAlbum?has_content>
<form name="picInAlbumForm" action="hotelAlbumDeletePic.action?id=${hotelAlbum.ID}" method="post">
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="30%" align="center">
	<tr class="title">
		<td colspan="7">相册照片信息（仅供从相册中删除，图片本身不会删除）</td>
	</tr>
	<tr class="stronghl">
		<td colspan="7"><div style="text-align:center">点击名称可预览照片。</div></td>
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
	<#assign count=1 />
	<#list picsInAlbum as pic>
	<tr>
		<td><input type="checkbox" name="picIds" value="${pic.PICID}"></td>
		<td>${count}</td>
		<td><a href="javascript:void(0)" onclick="showPic('${pic.PICID}','${pic.PICNAME}')">${pic.PICNAME}</a></td>
		<td>${pic.PICTIME?datetime}</td>
		<td>${pic.PICUSER}</td>
		<td><#if pic.PICTAG='common'>普通上传<#elseif pic.PICTAG='editor'>Editor上传</#if></td>
		<td><span id="picPath${pic.PICID}">${pic.PICPATH}</td>
	</tr>
	<#assign count=count+1 />
	</#list>
	<tr>
		<td colspan="7"><@app.submit id="picSubmitButton" value="删除" onclick="return checkSelected()"/>&nbsp;&nbsp;<@app.reset id="picResetButton" value="重置"/></td>
	</tr>
</table>
</form>
<#else>
<table class="default" width="100%">
	<tr class="title">
		<td>相册照片信息</td>
	</tr>
	<tr class="stronghl">
		<td><div style="text-align:center">相册内没有照片，请返回选择添加</div></td>
	</tr>
</table>
</#if>
</@p.page>