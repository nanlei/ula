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
         <#assign tour_category=request.getRequestURI()?substring(request.getRequestURI()?last_index_of("/")+1,request.getRequestURI()?last_index_of(".")) />
         <#assign tips="" />
         <#switch tour_category>
         	<#case "tour"><#assign tips="${action.getBundle('front.tour.business')}"><#break>
         	<#case "business"><#assign tips="${action.getBundle('front.tour.business')}"><#break>
         	<#case "camping"><#assign tips="${action.getBundle('front.tour.camping')}"><#break>
         	<#case "foodie"><#assign tips="${action.getBundle('front.tour.foodie')}"><#break>
         	<#case "family"><#assign tips="${action.getBundle('front.tour.family')}"><#break>
         	<#case "therapy"><#assign tips="${action.getBundle('front.tour.therapy')}"><#break>
         	<#case "newyear"><#assign tips="${action.getBundle('front.tour.newyear')}"><#break>
         	<#case "learn"><#assign tips="${action.getBundle('front.tour.learn')}"><#break>
         	<#case "romantic"><#assign tips="${action.getBundle('front.tour.romantic')}"><#break>
         	<#case "rural"><#assign tips="${action.getBundle('front.tour.rural')}"><#break>
         	<#case "event"><#assign tips="${action.getBundle('front.tour.event')}"><#break>
         	<#case "sport"><#assign tips="${action.getBundle('front.tour.sport')}"><#break>
         	<#case "hotspring"><#assign tips="${action.getBundle('front.tour.hotspring')}"><#break>
         	<#case "exhibition"><#assign tips="${action.getBundle('front.tour.exhibition')}"><#break>
         	<#case "luxurious"><#assign tips="${action.getBundle('front.tour.luxurious')}"><#break>
         </#switch>
            <div id="article_content">
            	<#if tourList?has_content>
                <p style="text-align:center;margin-top:5px;font-size:16px">当前分类：<b>${tips}</b></p>
            	<div style="border-top: 1px #CCCCCC dashed;margin-top:5px;"></div>
            	<#list tourList as tour>
            	<div id="page_article_title">
                	<p><a href="${base}/tour-${tour.ID}.html">${tour.TITLE}</a></p>
                </div>
                </#list>
                <#else>
                <div>
                	<p style="text-align:center;margin-top:5px;font-size:16px">当前分类：<b>${tips}</b><br>该分类下暂无行程信息</p>
                </div>
                </#if>
            </div>
	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>