<@p.page>
<@p.tree root="用户管理" display="block">
<script type="text/javascript"> 
var treeMenu = [
	<#if loginUser.USERROLE='admin'>
	{ level:1, name:"用户信息", link:"list.action"},
	{ level:1, name:"添加用户", link:"preAddUser.action"}
	<#else>
	{ level:1, name:"用户信息", link:"list.action"}
	</#if>
];
</script>
</@p.tree>
</@p.page>