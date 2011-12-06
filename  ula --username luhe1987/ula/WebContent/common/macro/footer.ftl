<#-- footer宏 -->
<#macro footer>
    <div class="clear"></div>
    <div id="links_bar">
    	<div id="lk_title"><@s.property value="%{getText('front.links')}"/></div>
    	<ul class="links">
    		<li><a href="#">Юридическая информация</a></li>
    		<li><a href="#">Юридическая информация</a></li>
    		<li><a href="#">Юридическая информация</a></li>
    	</ul>
    	<div class="clear"></div>
    </div>
    <div id="copyright">
    	<@s.property value="%{getText('front.copyright')}"/> © 2010-2012  <@s.property value="%{getText('front.company')}"/>
    </div>
</#macro>