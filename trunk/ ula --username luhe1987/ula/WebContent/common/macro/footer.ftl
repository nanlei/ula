<#-- footer宏 -->
<#macro footer>
    <div class="clear"></div>
    <div id="links_bar">
    	<div id="lk_title"><@s.property value="%{getText('front.links')}"/></div>
    	<ul class="links">
    		<li></li>
    		<#list linkList as link>
    		<li><a href="${link.URL}">${link.TITLE}</a></li>
    		</#list>
    	</ul>
    	
    	<div class="clear">
    </div>
    
    
    </div>
    <div id="copyright">
    	<@s.property value="%{getText('front.copyright')}"/> © 2010-2012  <@s.property value="%{getText('front.company')}"/>
    	&nbsp &nbsp 
    	 <!-- Yandex.Metrika informer -->
                   <a href="http://metrika.yandex.ru/stat/?id=7764022&amp;from=informer"
                      target="_blank" rel="nofollow">
                      <img src="http://bs.yandex.ru/informer/7764022/3_1_FFFFFFFF_EFEFEFFF_0_pageviews"
                       style="width:88px; height:31px; border:0;" alt="Яндекс.Метрика"
                       title="Яндекс.Метрика: данные за сегодня просмотры, визиты и уникальные посетители" />
                   </a>
                       
                        
<!-- /Yandex.Metrika informer -->
<!-- Yandex.Metrika counter -->
	           
	           
	           <!--LiveInternet counter--><script type="text/javascript"><!--
document.write("<a href='http://www.liveinternet.ru/click' "+
"target=_blank><img src='http://counter.yadro.ru/hit?t52.6;r"+
escape(document.referrer)+((typeof(screen)=="undefined")?"":
";s"+screen.width+"*"+screen.height+"*"+(screen.colorDepth?
screen.colorDepth:screen.pixelDepth))+";u"+escape(document.URL)+
";h"+escape(document.title.substring(0,80))+";"+Math.random()+
"' alt='' title='LiveInternet: показано число просмотров и"+
" посетителей за 24 часа' "+
"border='0' width='88' height='31'><\/a>")
//--></script>

<!-- Rating@Mail.ru counter -->
<script type="text/javascript">//<![CDATA[
var a='';js=10;d=document;
try{a+=';r='+escape(d.referrer);}catch(e){}try{a+=';j='+navigator.javaEnabled();js=11;}catch(e){}
try{s=screen;a+=';s='+s.width+'*'+s.height;a+=';d='+(s.colorDepth?s.colorDepth:s.pixelDepth);js=12;}catch(e){}
try{if(typeof((new Array).push('t'))==="number")js=13;}catch(e){}
try{d.write('<a href="http://top.mail.ru/jump?from=2086287"><img src="http://d5.cd.bf.a1.top.mail.ru/counter?id=2086287;t=230;js='+js+
a+';rand='+Math.random()+'" alt="Рейтинг@Mail.ru" style="border:0;" height="31" width="88" \/><\/a>');}catch(e){}//]]></script>
<noscript><p><a href="http://top.mail.ru/jump?from=2086287"><img src="http://d5.cd.bf.a1.top.mail.ru/counter?js=na;id=2086287;t=230" 
style="border:0;" height="31" width="88" alt="Рейтинг@Mail.ru" /></a></p></noscript>
<!-- //Rating@Mail.ru counter -->



	           
	           </span>
	
	</div>
	
<div style="display:none;">

<script type="text/javascript">
(function(w, c) {
    (w[c] = w[c] || []).push(function() {
        try {
            w.yaCounter7764022 = new Ya.Metrika({id:7764022, enableAll: true});
        }
        catch(e) { }
    });
})(window, 'yandex_metrika_callbacks');
</script></div>

  <script src="http://mc.yandex.ru/metrika/watch.js" type="text/javascript" defer="defer"></script>
  <noscript>
    <div>
	    <img src="http://mc.yandex.ru/watch/7764022" style="position:absolute; left:-9999px;" alt="" />
    </div>
  </noscript>	
    	
    </div>
</#macro>