<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店管理,详情修改" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店详情的信息，您可以维护这些信息。">
	<@app.button id="gobackButton" onclick="javascript:history.go(-1)" text="返回"/>
	</@app.naviInfo>
	<form name="hotelArticleForm" action="hotelArticleUpdate.action?id=${hotelInfo.ID}" method="post" onSubmit="return validateForm(this)">
	<table class="default" width="100%">
		<col width="40%" align="center">
		<col width="60%" align="center">
		<tr class="title">
			<td colspan="2">修改酒店信息</td>
		</tr>
		<tr>
			<td>名称</td>
			<td><input type="text" name="name" value="${hotelInfo.NAME}" emptyInfo="请输入酒店名称"></td>
		</tr>
		<tr>
			<td>位置</td>
			<td>
				<select name="location" emptyInfo="请选择酒店位置">
					<option>--请选择--</option>
					<#list locationList as location>
					<option value="${location.NAME}" <#if location.NAME=hotelInfo.LOCATION>selected="selected"</#if>>${location.VALUE}</option>
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
					<option value="${level.NAME}" <#if level.NAME=hotelInfo.LEVEL>selected="selected"</#if>>${level.VALUE}</option>
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
					<option value="${func.NAME}" <#if func.NAME=hotelInfo.FUNC>selected="selected"</#if>>${func.VALUE}</option>
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
					<option value="${album.ID}" <#if album.ID=hotelInfo.ALBUMID>selected="selected"</#if>>${album.NAME}</option>
					</#list>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<textarea name="content" id="content">${hotelInfo.CONTENT}</textarea><@p.ckeditor id="content"/>
			</td>
		</tr>
		<tr>
			<td colspan="2"><@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/></td>
		</tr>
	</table>
	</form>
</@p.page>