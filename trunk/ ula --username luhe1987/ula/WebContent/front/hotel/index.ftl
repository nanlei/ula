<@fp.page>
<!-- The Head -->
<@fp.header /><#-- header宏 -->
<!-- The Container  -->
<div id="container">
	<!-- The Banner  -->
	<@fp.banner /><#-- banner宏 -->
	<!-- The Navigation  -->
	<@fp.navigation c_index=false c_city=true c_tour=false c_service=false c_search=false c_contact=false /><#-- navigation宏 -->
	<!-- The Main Body -->
	<div id="main_body">
		<!-- The Left -->
		<@fp.main_left_tour /><#-- 主体左侧宏，包含关于大连导航，RSS订阅，天气预报-->
		 <!-- The Content -->
            <div id="article_content">
            	<div id="page_article_title">
                	<p>${hotel.NAME}</p>
                </div>
                <div style="text-align:center;margin-top:10px;margin-bottom:10px;">
					位置：<b>${hotel.LOCATION}</b><br>
					星级：<b>${hotel.LEVEL}</b><br>
					功能：<b>${hotel.FUNC}</b>
				</div>
                <div style="border-top: 1px #CCCCCC dashed;"/>
                	<#assign pIndex=picIndex/>
	   				<#list albumPicList as albumPic>
					<div style="text-align:center;margin-top:10px;margin-bottom:10px;">
						<img src="${base}${albumPic.PICPATH}" alt="${albumPic.PICNAME}" width="600" height="450"/>
					</div>
					
					</#list>
				</div>
                <div style="border-top: 1px #CCCCCC dashed;"/>
            	<div id="page_article">
            	<p>${hotel.CONTENT}</p>
            	</div>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>