<@p.page>
	<@app.naviBar navi="关于城市,展会信息" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示系统内的所有的关于城市->展会信息的文章，您可以维护这些信息。">
	<a class="navlink" href="preAddExhibition.action">添加文章</a>
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
	<#list exhibitionList.list as exhibition>
	<tr>
		<td>${count}</td>
		<td>${exhibition.TITLE}</td>
		<td>${exhibition.USERNAME}</td>
		<td>${exhibition.ADDTIME?datetime}</td>
		<td>${exhibition.COVERLINK?default("未选择")}</td>
		<td>${exhibition.PRICE?default("0")}</td>
		<td><a href="preUpdateExhibition.action?articleId=${exhibition.ID}">修改</a> | <a href="deleteExhibition.action?articleId=${exhibition.ID}&articleType=exhibition" onclick="return confirm('确定删除么?')">删除</a></td>
	</tr>
	<#assign count=count+1>
	</#list>
</table>
<div align="right">
	<@p.paging exhibitionList />
</div>
<#if count=1>
	<p align="center"><font color="red">尚未添加文章</font></p>
</#if>
</@p.page>