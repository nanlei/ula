<@p.page>

<#if alertMessage?exists><p align="center">${alertMessage}</p></#if>
 
 <div class="add"><a href="link!preAdd.action"><img
			src="${base}/icon/add.jpg" border="0"
			height="30px" width="30px" />添加</a>
</div>

<#if linkList.rowCount!=0>
 <table class="default" width="70%" align="center">
	<col width="30%" align="center"/>
	<col width="20%" align="center"/>
	<col width="30%" align="center"/>
	<col width="10%" align="center"/>
	<col width="10%" align="center"/>
	
			<tr class="title">
				<td>链接名称</td>
				<td>添加时间</td>
				<td>URL（网络地址）</td>
				<td colspan="2" align="center">操作</td>
			</tr>
			
				<#list linkList.list as link>
					<tr class="alt">
				<td>${link.title}</td>
				<td>${link.date}</td>
	            <td>${link.url}</td>
				<td><a href="link!edit.action?id=${link.Id}">修改</a></td>
				<td><a href="link!remove.action?id=${link.Id}">删除</a></td>
			    </tr>
	            </#list>
			
		</table>
		
</#if>
</@p.page>