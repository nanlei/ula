<#-- navigation宏 -->
<#macro navigation c_index c_city c_tour c_service c_search c_contact>
    <div id="nav">
    	<ul>
    		<li><a<#if c_index> class="clicked"</#if> href="${base}/index.html"><@s.property value="%{getText('front.nav.homepage')}"/></a></li>
    		<li><a<#if c_city> class="clicked"</#if> href="${base}/city.html"><@s.property value="%{getText('front.nav.about.dalian')}"/></a></li>
    		<li<#if locale='ru'> class="sp"</#if>><a<#if c_tour> class="clicked"</#if> href="${base}/tour.html"><@s.property value="%{getText('front.nav.jounery.tour')}"/></a></li>
    		<li<#if locale='ru'> class="sp"</#if>><a<#if c_service> class="clicked"</#if> href="#"><@s.property value="%{getText('front.nav.special.service')}"/></a></li>
    		<li><a<#if c_search> class="clicked"</#if> href="#"><@s.property value="%{getText('front.nav.search')}"/></a></li>
    		<li><a<#if c_contact> class="clicked"</#if> href="#"><@s.property value="%{getText('front.nav.contact.us')}"/></a></li>
    		<li<#if locale='ru'> class="sp"</#if>><a href="#"><@s.property value="%{getText('front.nav.online.contact')}"/></a></li>
    	</ul>
    </div>
</#macro>