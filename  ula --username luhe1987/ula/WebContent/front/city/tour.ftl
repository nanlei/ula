<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=true c_tour=false c_service=false c_search=false c_contact=false c_online=false/><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            	<div id="page_article_title">
                	<p>${cityTour.TITLE}</p>
                </div>
            	<div id="page_article">
            	<p>${cityTour.CONTENT}</p>
            	</div>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>