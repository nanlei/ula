<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店的信息，您可以维护这些信息。">
	<@app.button id="newArticleButton" onclick="$('#newArticle').toggle();this.blur();return false;" text="添加酒店"/>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<div id="newArticle" style="display:none">
	<form name="articleForm" action="hotelArticleAdd.action" method="post" onSubmit="return validateForm(this)">
	<table class="default" width="100%">
		<col width="40%" align="center">
		<col width="60%" align="center">
		<tr class="title">
			<td colspan="2">添加酒店</td>
		</tr>
		<tr>
			<td>名称</td>
			<td><input type="text" name="name" emptyInfo="请输入酒店名称"></td>
		</tr>
		<tr>
			<td>位置</td>
			<td>
				<select name="location" emptyInfo="请选择酒店位置">
					<option>--请选择--</option>
					<#list locationList as location>
					<option value="${location.VALUE}">${location.NAME}</option>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td>星级</td>
			<td>
				<select name="level" emptyInfo="请选择酒店星级">
					<option>--请选择--</option>
					<#list levelList as level>
					<option value="${level.VALUE}">${level.NAME}</option>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td>功能</td>
			<td>
				<select name="func" emptyInfo="请选择酒店功能">
					<option>--请选择--</option>
					<#list funcList as func>
					<option value="${func.VALUE}">${func.NAME}</option>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td>相册</td>
			<td>
				<select name="albumId" emptyInfo="请选择酒店相册">
					<option>--请选择--</option>
					<#list albumList as album>
					<option value="${album.ID}">${album.NAME}</option>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="content" id="content"></textarea><@p.ckeditor id="content"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/></td>
		</tr>
	</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>名称</td>
		<td>位置</td>
		<td>星级</td>
		<td>功能</td>
		<td>相册</td>
		<td>发布时间</td>
		<td>发布者</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list hotelList.list as hotel>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${hotel.NAME}</td>
		<td>${hotel.LOCATION}</td>
		<td>${hotel.LEVEL}</td>
		<td>${hotel.FUNC}</td>
		<td>${hotel.ALBUMNAME}</td>
		<td>${hotel.POSTTIME?datetime}</td>
		<td>${hotel.USERNAME}</td>
		<td><a href="hotelArticlePreUpdate.action?id=${hotel.ID}">修改</a> | <a href="hotelArticleDelete.action?id=${hotel.ID}" onclick="return confirm('确定删除吗？')">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<div align="right">
	<@p.paging hotelList />
</div>
</@p.page>