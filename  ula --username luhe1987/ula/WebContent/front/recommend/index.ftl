<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=true c_city=false c_tour=false c_service=false c_search=false c_contact=false /><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left />
		 <!-- The Content -->
            <div id="article_content">
            	<#if recommend?has_content>
            	<div id="page_article_title">
                	<p>${recommend.TITLE}</p>
                </div>
            	<div style="text-align:center;margin-top:10px;">
                	<p><img src="${base}${recommend.COVER}" title="${recommend.TITLE}" alt="<@s.property value="%{getText('front.recommend.image.alt')}"/>" /></p>
                </div>
                <div style="margin-top:10px;border-bottom: 1px #CCCCCC dashed;"></div>
            	<div id="page_article">
            	<p>${recommend.CONTENT}</p>
            	</div>
            	<#else>
            	<div id="page_article_title">
                	<p>暂无数据显示</p>
                </div>
            	</#if>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>