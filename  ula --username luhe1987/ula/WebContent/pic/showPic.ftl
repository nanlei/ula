<@p.page>
	<@app.naviBar navi="图片管理,普通上传,图片详情" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示图片的详情信息。">
	<a href="javascript:history.go(-1)" class="navlink">返回</a>
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="20%" align="center"/>
	<col width="30%" align="center"/>
	<col width="20%" align="center"/>
	<col width="30%" align="center"/>
	<tr class="title">
		<td colspan="4">图片详情</td>
	</tr>
	<tr>
		<td>图片名</td><td>${picInfo.PICNAME}</td>
		<td>上传时间</td><td>${picInfo.PICTIME}</td>
	</tr>
	<tr>
		<td>上传人</td><td>${picInfo.PICUSER}</td>
		<td>图片地址</td><td>${picInfo.PICPATH}</td>
	</tr>
	<tr>
		<td colspan="4"><img src="${base}${picInfo.PICPATH}" style="margin-top='20px'" ></img></td>
	</tr>
</table>
</@p.page>