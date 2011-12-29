<html>
<head>
<title>后台管理登录</title>
<link href="${base}/css/default.css" rel="stylesheet" type="text/css" />
<link href="${base}/css/jqueryui/start/jquery-ui-1.8.16.custom.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${base}/js/jquery-1.7.1.min.js"></script>
<script language="javascript" src="${base}/js/jquery-ui-1.8.16.custom.min.js"></script>
<script language="javascript" src="${base}/js/common.js"></script>
<style>
table.default {
	border:1ps solid #999;
}
table.default tr.ltitle td, table.default tr.title td {
	border-bottom:0px solid #0283c5;
	background:url(../images/icon/bg.gif);
	color:#333;
	border:0;
}
table.default td {
	border:0;
	background:#fff;
	height:23px;
}
</style>
<script type="text/javascript">
$(document).ready(
	function(){
		$('#submitButton').button();
		$('#resetButton').button();
	}
);
</script>
</head>
<body>
<table width="100%" height="100%">
<tr>
	<td valign="middle">
	<table align="center" width="300px" cellspacing="20px" cellpadding="0" border="0" style="background:#fff">
	<tr>
		<td width="30%" valign="top">
			<form action="login" name="loginForm" onsubmit="return validateForm(this)" method="post">
			<table border="0" align="center" cellpadding="0" cellspacing="0" class="default" width="100%">
				<tr class="title">
					<td colspan="2" align="center">JoyTour&nbsp;&nbsp;管理系统</td>
				</tr>
				<tr>
					<td colspan="2" class="errorMessage" align="center"><#if errorInfo?exists>${errorInfo}</#if></td>
				</tr>
				<tr>
					<td class="item" align="right" width="35%">用户名:</td>
					<td><input type="text" name="userName" style="width:130px" emptyInfo="请输入用户名。"></td>
				</tr>
				<tr>
					<td class="item" align="right">密　码:</td>
					<td><input type="password" name="password" style="width:130px" emptyInfo="请输入密码。"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" id="submitButton" value="登录">&nbsp;&nbsp;
						<input type="reset" id="resetButton" value="重置">
					</td>
				</tr>
			</table>
			</form>
		</td>
	</tr>
	</table>
	</td>
</tr>
</table>
</body>
</html>