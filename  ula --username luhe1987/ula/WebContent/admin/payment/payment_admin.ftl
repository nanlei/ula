<#if alertMessage?exists>${alertMessage}</#if>

<#if payment?exists>
 <table id="customers">
			<tr>
				<td>标题</td>
				<td>发布时间</td>
				<td colspan="3" align="center">操作</td>
			</tr>
			<tr class="alt">
				<td>${payment.title}</td>
				<td>${payment.date}</td>
	
				<td class="operation"><a href="payment!edit.action">修改</a></td>
				<td class="operation">删除</td>
			</tr>
		</table>
<#else>
 <div class="add"><a href="payment!preAdd.action"><img
			src="<%=request.getContextPath()%>/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>
</#if>  