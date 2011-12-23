<#include "config.ftl">
<html>
<head>
<meta http-equiv="Content-type" content="text/html; charset=${macro_config.charset}">
<#list macro_config.css_path as css><#-- 系统CSS加载 -->
<link href="${base}${css}" rel="stylesheet" type="text/css">
</#list>
<#list macro_config.js_path as js><#-- 系统JS加载 -->
<script language="javascript" src="${base}${js}"></script>
</#list>
</head>
<body>
<#assign exception = stack.context["_exception_"]>
<#assign exceptionDetail = stack.context["_exception_info_"]>
<table border="0" cellpadding="0" cellspacing="1" class="default" style="width:50%" align="center">
<tr class="title">
	<td style="text-align:center;color:red">系统操作出现异常</td>
</tr>
<tr>
	<td align="center" style="line-height:150%;padding:10px">
	<table width="90%"><tr><td style="padding:10px;background:#FFCCCC;border:1px solid black;width:90%">错误原因：${exception?if_exists?html}</td></tr></table>
	<br>
	请选择以下任务继续：<br><br>
	<a href="javascript:history.go(-1)">返回</a> | <a href="javascript:void(0)" onclick="$('#explaintab').toggle();this.blur();return false;">查看错误详细信息</a>
	</td>
</tr>
</tr>
</table>
<table class="explain" width="100%" align="center" style="display:none" id="explaintab">
<tr>
	<td>
	<textarea rows="15" style="width:100%;font-family:Courier New">${exceptionDetail?if_exists?html}</textarea>
	</td>
</tr>
</table>
</body>
</html>