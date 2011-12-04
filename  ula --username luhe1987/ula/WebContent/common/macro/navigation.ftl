<#-- navigation宏 -->
<#macro navigation>
    <div id="nav">
    	<ul>
    		<li><a class="clicked" href="#"><@s.property value="%{getText('front.nav.homepage')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.about.dalian')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.jounery.tour')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.special.service')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.search')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.contact.us')}"/></a></li>
    		<li><a href="#"><@s.property value="%{getText('front.nav.online.contact')}"/></a></li>
    	</ul>
    </div>
</#macro>