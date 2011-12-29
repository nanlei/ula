<@p.page>
	<@app.naviBar navi="友情链接" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的友情链接，您可以维护这些信息。">
	<@app.button id="newLinkButton" onclick="$('#newLink').toggle();this.blur();return false;" text="添加链接"/>
	</@app.naviInfo>
<div id="newLink" style="display:none">
	<form name="linkForm" action="link!add.action" method="post" onSubmit="return validateForm(this)">
		<table class="default" width="100%">
			<col width="40%" align="center">
			<col width="60%" align="center">
			<tr class="title">
				<td colspan="2">添加连接</td>
			</tr>
			<tr>
				<td>名称<@p.mustMark /></td>
				<td>
					<input type="text" name="title" size="40" maxLength="30" emptyInfo="请输入链接名称">
				</td>
			</tr>
			<tr>
				<td>地址(http开头)<@p.mustMark /></td>
				<td><input type="text" name="url" size="40" maxLength="100" emptyInfo="请输入链接地址"></td>
			</tr>
			<tr>
				<td>是否显示</td>
				<td><input type="radio" name="tag" value="1" checked="checked">是&nbsp;&nbsp;<input type="radio" name="tag" value="0">否</td>
			</tr>
				<td colspan="2">
					<@app.submit id="submitButton" value="提交" />&nbsp;&nbsp;<@app.reset id="resetButton" value="重置"/>
				</td>
			</tr>
		</table>
	</form>
</div>
 <table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="25%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="15%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>名称</td>
		<td>地址</td>
		<td>是否显示</td>
		<td>更新人</td>
		<td>更新时间</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list linkList.list as link>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${link.TITLE}</td>
		<td>${link.URL}</td>
		<td><#if link.TAG=1>是<#else>否</#if></td>
		<td>${link.USERNAME}</td>
		<td>${link.DATE?datetime}</td>
		<td><a href="link!preUpdate.action?id=${link.ID}">修改</a> | <a href="link!delete.action?id=${link.ID}" onclick="return confirm('确定删除么?')">删除</a></td>
	</tr>
	<#assign count=count+1>
	</#list>	
</table>
<div align="right">
	<@p.paging linkList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加链接</font></p>
</#if>
</@p.page>