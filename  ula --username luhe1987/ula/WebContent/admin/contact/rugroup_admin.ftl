<#if alertMessage?exists>${alertMessage}</#if>
<#if ruGroup?exists>
 <table id="customers">
			<tr>
				<td>标题</td>
				<td>发布时间</td>
				<td colspan="3" align="center">操作</td>
			</tr>
			<tr class="alt">
				<td>${ruGroup.title}</td>
				<td>${ruGroup.date}</td>
	
				<td class="operation"><a href="rugroup!edit.action">修改</a></td>
				<td class="operation">删除</td>
			</tr>
		</table>
<#else>
 <div class="add"><a href="rugroup!preAdd.action"><img
			src="<%=request.getContextPath()%>/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>
<#if alertMessage?exists>${alertMessage}</#if>
</#if>  