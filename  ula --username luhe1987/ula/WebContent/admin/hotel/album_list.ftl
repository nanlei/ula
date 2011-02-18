<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店相册管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店相册的信息，您可以维护这些信息。">
	<@app.button id="newAlbumButton" onclick="$('#newAlbum').toggle();this.blur();return false;" text="添加相册"/>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<div id="newAlbum" style="display:none">
	<form name="paramForm" action="addHotelAlbum.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加相册</td>
			</tr>
			<tr>
				<td>相册名称</td>
				<td>
					<input type="text" name="name" size="40" maxLength="50" emptyInfo="请输入相册名称">
				</td>
			</tr>
			<tr>
				<td>相册内容</td>
				<td><textarea name="content" cols="80" rows="10" emptyInfo="请输入相册内容"></textarea>
			</tr>
			<tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="30%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="20%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>相册名称</td>
		<td>相册内容</td>
		<td>发布时间</td>
		<td>发布者</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list hotelAlbums.list as hotelAlbum>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${hotelAlbum.NAME}</td>
		<td>${hotelAlbum.CONTENT}</td>
		<td>${hotelAlbum.POSTTIME?datetime}</td>
		<td>${hotelAlbum.USERNAME}</td>
		<td><a href="hotelAlbumPreUpdate.action?id=${hotelAlbum.ID}">修改</a> | <a href="hotelAlbumDelete.action?id=${hotelAlbum.ID}" onclick="return confirm('确定删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
</@p.page>