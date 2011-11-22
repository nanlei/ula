<@p.page>
	<@app.naviBar navi="关于城市,大连交通" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->大连交通的文章，您可以维护这些信息。">
	<a class="navlink" href="preAddTransportation.action">添加文章</a>
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<table class="default" width="100%">
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<col width="25%" align="center"/>
	<col width="10%" align="center"/>
	<col width="15%" align="center"/>
	<tr class="title">
		<td>序号</td>
		<td>标题</td>
		<td>添加人</td>
		<td>添加时间</td>
		<td>图片地址</td>
		<td>参考价格</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*10+1>
	<#list transportationList.list as transportation>
	<tr>
		<td>${count}</td>
		<td>${transportation.TITLE}</td>
		<td>${transportation.USERNAME}</td>
		<td>${transportation.ADDTIME?datetime}</td>
		<td>${transportation.COVERLINK?default("未选择")}</td>
		<td>${transportation.PRICE?default("0")}</td>
		<td><a href="preUpdateTransportation.action?articleId=${transportation.ID}">修改</a> | <a href="deleteTransportation.action?articleId=${transportation.ID}&articleType=transportation" onclick="return confirm('确定删除么?')">删除</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<div align="right">
	<@p.paging transportationList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加文章</font></p>
</#if>
</@p.page>