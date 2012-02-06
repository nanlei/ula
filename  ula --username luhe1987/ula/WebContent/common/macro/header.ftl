<#-- header宏 -->
<#macro header>
<div id="head_warpper">
	<div id="top_bar">
		<span><@s.property value="%{getText('front.company')}"/></span>
	</div>
		<span class="lang">
			<a href="${base}/language/zh" style="color:white"><@s.property value="%{getText('front.version.chinese')}"/></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="${base}/language/en" style="color:white"><@s.property value="%{getText('front.version.english')}"/></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="${base}/language/ru" style="color:white"><@s.property value="%{getText('front.version.russian')}"/></a>&nbsp;
		</span>
</div>
</#macro>