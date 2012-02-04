<#-- banner宏 -->
<#macro banner>
	<div id="banner">
		<div id="logo">
			<img src="${base}/images/logo.png" title="<@s.property value="%{getText('front.company')}"/>" alt="LOGO"/>
		</div>
		<ul id="banner_ad">
			<#list recommendList as recommend>
			<li class="single_img">
				<a href="${base}/recommend-${recommend.ID}.html"><img src="${base}${recommend.COVER}" title="${recommend.TITLE}" alt="<@s.property value="%{getText('front.recommend.image.alt')}"/>" /></a>
				<p style="text-align:center">${recommend.TITLE}</p>
			</li>
			</#list>
		</ul>
	</div>
</#macro>