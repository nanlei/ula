<#-- header宏 -->
<#macro header>
<div id="head_warpper">
	<div id="top_bar">
		<span>
			<a href="language.action?locale=zh" style="color:white"><@s.property value="%{getText('front.version.chinese')}"/></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="language.action?locale=en" style="color:white"><@s.property value="%{getText('front.version.english')}"/></a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="language.action?locale=ru" style="color:white"><@s.property value="%{getText('front.version.russian')}"/></a>&nbsp;
		</span>
		<span><@s.property value="%{getText('front.company')}"/></span>
	</div>
</div>
</#macro>