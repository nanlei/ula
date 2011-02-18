<@p.page>
	<@app.naviBar navi="关于城市,大连酒店,酒店参数管理" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连酒店->酒店参数的信息，您可以维护这些信息。">
	<a class="navlink" href="javascript:void(0)" onclick="$('#newParam').toggle();this.blur();return false;">添加参数</a>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<div id="newParam" style="display:none">
	<form name="paramForm" action="addParam.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加参数</td>
			</tr>
			<tr>
				<td>参数类型</td>
				<td>
					<select name="type" emptyInfo="请选择参数类型">
						<option value="location">位置</option>
						<option value="level">星级</option>
						<option value="func">功能</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>参数名称</td>
				<td><input type="text" name="paramName" emptyInfo="请输入参数名称"></td>
			</tr>
			<tr>
				<td>显示内容</td>
				<td><input type="text" name="paramValue" emptyInfo="请输入参数值"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="提交" class="btn">&nbsp;&nbsp;<input type="reset" value="重置" class="btn"></td>
			</tr>
		</table>
	</form>
</div>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="25%" align="center">
	<col width="25%" align="center">
	<col width="25%" align="center">
	<col width="15%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>参数类型</td>
		<td>参数名称</td>
		<td>显示内容</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list hotelParams.list as hotelParam>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td><#if hotelParam.TYPE='location'>位置<#elseif hotelParam.TYPE='level'>星级<#else>功能</#if></td>
		<td>${hotelParam.NAME}</td>
		<td>${hotelParam.VALUE}</td>
		<td><a href="hotelParamPreUpdate.action?id=${hotelParam.ID}">修改</a> | <a href="hotelParamDelete.action?id=${hotelParam.ID}">删除</a></td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
</@p.page>