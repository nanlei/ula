<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=false c_service=false c_search=false c_contact=true c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_about /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            	<div id="page_article_title">
                	<p><@s.property value="%{getText('front.online.chat')}"/></p>
                </div>
            	<div id="page_article">
            	<p align= "center">
            		<iframe frameborder="0" height="500" scrolling="no" src="http://settings.messenger.live.com/Conversation/IMMe.aspx?invitee=5e608603b20437df@apps.messenger.live.com&amp;mkt=ru" style="border: solid 1px black; width: 600px; height: 500px;" width="600"></iframe>
            	</p>
            	</div>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>