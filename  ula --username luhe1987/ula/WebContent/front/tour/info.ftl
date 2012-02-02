<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=false c_tour=true c_service=false c_search=false c_contact=false /><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_tour /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            	<div id="page_article_title">
                	<p>${tour.TITLE}</p>
                </div>
                <div style="margin-top:10px;height:150px;">
                	<div style="float:left;width:210px;"><img src="${base}${tour.COVERLINK}" alt="" /></div>
                	<div style="float:right;width:515px;">${tour.DESCRIPTION}</div>
                </div>
                <div style="border-top: 1px #CCCCCC dashed;"/>
            	<div id="page_article">
            	<p>${tour.CONTENT}</p>
            	</div>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>