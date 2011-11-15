<@p.page>
	<@app.naviBar navi="图片管理,Editor上传,图片信息" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有Editor上传的图片，您可以维护这些信息。">
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<table class="default" width="100%">
	<col width="8%" align="center"/>
	<col width="14%" align="center"/>
	<col width="8%" align="center"/>
	<col width="15%" align="center"/>
	<col width="40%" align="center"/>
	<col width="15%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>图片名</td>
		<td>上传人</td>
		<td>上传时间</td>
		<td>图片地址</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list picList.list as pic>
	<tr>
		<td>${count}</td>
		<td>${pic.PICNAME?default("")}</td>
		<td>${pic.PICUSER?default("")}</td>
		<td>${pic.PICTIME?datetime?default("")}</td>
		<td>${pic.PICPATH?default("")}</td>
		<td><a href="showPic.action?picId=${pic.PICID}">查看</a> | <a href="deleteEditorPic.action?picId=${pic.PICID}" onclick="return confirm('确定要删除该图片么?')">删除</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<div align="right">
	<@p.paging picList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加图片</font></p>
</#if>
</@p.page>