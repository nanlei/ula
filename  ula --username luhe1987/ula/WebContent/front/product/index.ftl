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
		 <#if product?has_content>
		 <@fp.main_middle_product product />
		 <#else>
		 <div style="text-align:center;font-size:18px">暂无信息</div>
		 </#if>

	</div>
    <!-- The Footer -->
	<@fp.footer /><#-- footer宏 -->
</div>
</@fp.page>