<@p.page>
	<@app.naviBar navi="天气预报" />
	<@app.naviInfo helpInfoTitle="查看页面说明" helpInfoContent="本页面显示天气预报信息。如需修改，请联系开发人员">
	</@app.naviInfo>
	<#if alertMessage?exists>
	${alertMessage}
	</#if>
<table class="default" width="100%">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<col width="10%" align="center">
	<col width="15%" align="center">
	<tr class="title">
		<td>序号</td>
		<td>城市</td>
		<td>今日气温</td>
		<td>今日天气</td>
		<td>明日气温</td>
		<td>明日天气</td>
		<td>更新时间</td>
		<td>默认城市</td>
		<td>操作</td>
	</tr>
	<#assign count=(pageNum-1)*pageSize+1 />
	<#list weatherList.list as weather>
	<tr <@p.trChangeColor />>
		<td>${count}</td>
		<td>${weather.CITYNAME}</td>
		<td>${weather.TEMP1}</td>
		<td><img src="http://m.weather.com.cn/img/b${weather.IMG1}.gif" width="26" height="26" />
			<#if weather.IMG2?number?int!=99>
			<img src="http://m.weather.com.cn/img/b${weather.IMG2}.gif" width="26" height="26" />
			</#if>
		</td>
		<td>${weather.TEMP2}</td>
		<td><img src="http://m.weather.com.cn/img/b${weather.IMG3}.gif" width="26" height="26" alt="network error"/>
			<#if weather.IMG4?number?int!=99>
			<img src="http://m.weather.com.cn/img/b${weather.IMG4}.gif" width="26" height="26" alt="network error"/>
			</#if>
		</td>
		<td>${weather.UPDATETIME?datetime}</td>
		<td><#if weather.TAG=1>是<#else>否</#if></td>
		<td><a href="weather!update.action?id=${weather.ID}">立即更新</a>
			<#if weather.TAG=0> | <a href="weather!setToDefault.action?id=${weather.ID}" onclick="return confirm('确定要设置${weather.CITYNAME}为默认城市吗？')">设为默认</a></#if>
		</td>
	</tr>
	<#assign count=count+1 />
	</#list>
</table>
<#if weatherList.list.size()=0>
<div align="center" style="margin-top:5px;font-size:14px;color:red;">暂无天气信息</div>
</#if>
<div align="right">
	<@p.paging weatherList />
</div>
</@p.page>