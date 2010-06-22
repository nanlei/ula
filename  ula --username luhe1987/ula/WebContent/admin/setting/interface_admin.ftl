
<#if alertMessage?exists>
${alertMessage}
</#if>
 <div class="add"><a href="interface!preAdd.action"><img
			src="<%=request.getContextPath()%>/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>

<#if lanList.rowCount!=0>
 <table class="default" width="70%" align="center">
	<col width="30%" />
	<col width="20%" />
	<col width="30%" />
	<col width="10%" />
	<col width="10%" />
	
			<tr class="title">
				<td>中文原文</td>
				<td>俄文译文</td>
				<td>页面引用（别修改）</td>
				<td colspan="2" align="center">操作</td>
			</tr>
			
				<#list lanList.list as lan>
					<tr class="alt">
				<td>${lan.CN}</td>
				<td><#if lan.RU="">暂无<#else>${lan.RU?default("暂无")}</#if></td>
	            <td>${lan.TAG}</td>
				<td><a href="interface!edit.action?id=${lan.Id}">修改</a></td>
				<td><a href="interface!remove.action?id=${lan.Id}">删除</a></td>
			    </tr>
	            </#list>
			
		</table>
		
		<div align="center"><@p.paging lanList/></div>
</#if>