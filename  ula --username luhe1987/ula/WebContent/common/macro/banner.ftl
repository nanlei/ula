<#-- banner宏 -->
<#macro banner>
	<div id="banner">
		<div id="logo">
		<a href="${base}"><img src="${base}/images/logo.png" title="<@s.property value="%{getText('front.company')}"/>" alt="LOGO"/></a>
		</div>
		<ul id="banner_ad">
			<#list recommendList as recommend>
			<li class="single_img">
			<#if recommend.LINK?has_content>
				<a href="${recommend.LINK}"><img src="${base}${recommend.COVER}" title="${recommend.TITLE}" alt="<@s.property value="%{getText('front.recommend.image.alt')}"/>" /></a>
			<#else>
				<a href="${base}/recommend-${recommend.ID}.html"><img src="${base}${recommend.COVER}" title="${recommend.TITLE}" alt="<@s.property value="%{getText('front.recommend.image.alt')}"/>" /></a>
			</#if>
				<p style="text-align:center">${recommend.TITLE}</p>
			</li>
			</#list>
		</ul>
	</div>
</#macro>