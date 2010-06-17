<@p.page>
	<@app.naviBar navi="用户管理,添加用户" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面用来填写用户信息，添加新用户。">
	</@app.naviInfo>
<form name="userForm" action="addUser.action" method="post" onSubmit="return validateForm(this)">
<table class="default" width="100%">
	<col width="50%" align="right" />
	<col width="50%" align="left" />
	<tr class="title">
		<td colspan="2">用户信息修改</td>
	</tr>
	<tr>
		<td>用户名</td><td><input type="text" name="userName" emptyInfo="用户名不能为空"></td>
	</tr>
	<tr>
		<td>真实名</td><td><input type="text" name="realName" emptyInfo="真实名不能为空"></td>
	</tr>
	<tr>
		<td>密码</td><td><input type="password" name="password" emptyInfo="密码不能为空"></td>
	</tr>
	<tr>
		<td>用户角色</td><td><input type="radio" name="userRole" value="admin">超级管理员&nbsp;&nbsp;<input type="radio" name="userRole" value="user" checked>普通用户</td>
	</tr>
	<tr>
		<td colspan="2" align="center"><input type="submit" class="btn" value="提交">&nbsp;&nbsp;<input type="reset" class="btn" value="重置"></td>
	</tr>
</table>
</form>
</@p.page>