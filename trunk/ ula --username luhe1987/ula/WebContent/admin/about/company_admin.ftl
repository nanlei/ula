<@p.page>
<@app.naviBar navi="关于我们,公司介绍" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用于公司介绍内容编辑，用户可以修改公司介绍内容">
	</@app.naviInfo>
<#if alertMessage?exists><p align="center">${alertMessage}</p></#if>

<#if companyInfo?exists>
<table class="default" width="70%" align="center">
	<col width="40%" align="center"/>
	<col width="40%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	
			<tr class ="title">
				<td>标题</td>
				<td>发布时间</td>
				<td colspan="2" align="center">操作</td>
			</tr>
			<tr class="alt">
				<td>${companyInfo.title}</td>
				<td>${companyInfo.date}</td>
	
				<td class="operation"><a href="company!edit.action">修改</a></td>
				<td class="operation">删除</td>
			</tr>
		</table>
<#else>
 <div class="add"><a href="company!preAdd.action"><img
			src="${base}/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>
</#if>

</@p.page>   