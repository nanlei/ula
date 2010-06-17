<@p.page>
	<@app.naviBar navi="用户管理,用户信息,信息修改" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面可以修改用户的信息。">
	</@app.naviInfo>
<#assign admin=''/>
<#assign user=''/>
<#if userInfo.userRole='admin'>
<#assign admin='checked'/>
<#else>
<#assign user='checked'/>
</#if>
<form name="userForm" action="updateUser.action?userId=${userInfo.USERID}" method="post" onSubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="50%" align="right" />
	<col width="50%" align="left" />
	<tr class="title">
		<td colspan="2">用户信息修改</td>
	</tr>
	<tr>
		<td>用户名</td><td>${userInfo.USERNAME}</td>
	</tr>
	<tr>
		<td>真实名</td><td><input type="text" name="realName" value="${userInfo.REALNAME}" emptyInfo="真实名不能为空"></td>
	</tr>
	<tr>
		<td>密码</td><td><input type="password" name="password" value="${userInfo.PASSWORD}" emptyInfo="密码不能为空"></td>
	</tr>
	<tr>
		<td>用户角色</td><td><input type="radio" name="userRole" value="admin" ${admin}>超级管理员&nbsp;&nbsp;<input type="radio" name="userRole" value="user" ${user}>普通用户</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" value="提交">&nbsp;&nbsp;<input type="reset" value="重置"></td>
	</tr>
</table>
</form>
</@p.page>