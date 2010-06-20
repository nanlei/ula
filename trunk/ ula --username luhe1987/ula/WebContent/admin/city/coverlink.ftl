<@p.page>
	<@app.naviBar navi="选择封面" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面您可以选择封面的图片链接地址，您复制链接后直接复制到需要填写的位置即可。">
	<a class="navlink" href="javascript:window.close()">关闭窗口</a>
	</@app.naviInfo>
<table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="50%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>图片名</td>
		<td>上传人</td>
		<td>上传时间</td>
		<td>图片地址</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list pictureList.list as pic>
	<tr>
		<td>${count}</td>
		<td>${pic.PICNAME?default("")}</td>
		<td>${pic.PICUSER?default("")}</td>
		<td>${pic.PICTIME?datetime?default("")}</td>
		<td>${pic.PICPATH?default("")}</td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<div align="right">
	<@p.paging pictureList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加图片</font></p>
</#if>
</@p.page>