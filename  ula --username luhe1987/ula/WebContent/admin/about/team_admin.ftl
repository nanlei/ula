<#if alertMessage?exists>${alertMessage}</#if>

<#if teamInfo?exists>
 <table id="customers">
			<tr>
				<td>标题</td>
				<td>发布时间</td>
				<td colspan="3" align="center">操作</td>
			</tr>
			<tr class="alt">
				<td>${teamInfo.title}</td>
				<td>${teamInfo.date}</td>
	
				<td class="operation"><a href="team!edit.action">修改</a></td>
				<td class="operation">删除</td>
			</tr>
		</table>
<#else>
 <div class="add"><a href="team!preAdd.action"><img
			src="<%=request.getContextPath()%>/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>
</#if>  