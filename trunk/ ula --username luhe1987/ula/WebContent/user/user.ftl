<@p.page title="用户管理" body="style=\"margin:0;color:#fff\" scroll=\"no\"">
<table width="100%" height="100%" cellspacing="0" cellpadding="0" border="0" align="center" class="fbg" style="height:100%">
	<tr>
		<td height="65px">
			<table width="100%" cellspacing="0" cellpadding="0" border="0" class="bbg">
				<tr>
					<td>
						<@app.header>
							<td width="80" class="tdnormal"><div style="border-left:1px solid white"><a class="navbar" href="${base}/admin/index">系统管理</a></div></td>
							<td width="80" class="tdnormal"><div style="border-left:1px solid white"><a class="navbar" href="${base}/pic/admin.action">图片管理</a></div></td>
							<td width="80" class="tdselected fbg"><a class="navbar" href="${base}/user/admin.action">用户管理</a></td>
							<td width="80" class="tdnormal"><div><a class="navbar" href="${base}/reservation/admin.action">订单管理</a></div></td>
							<td width="100" class="tdnormal"><div style="border-left:1px solid white"><a class="navbar" href="${base}/feedback/admin.action">用户反馈管理</a></div></td>
							<td class="tdnormal"><div style="border-left:1px solid white">&nbsp;</div></td>
							<td class="tdnormal">&nbsp;</td>
						</@app.header>
					</td>
				</tr>
				<tr>
					<td height="5" class="fbg"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td valign="top">
			<@app.body treeAction="admintree.action" displayPage=""/>
		</td>
	</tr>
	<@app.footer/>
</table>
</@p.page>